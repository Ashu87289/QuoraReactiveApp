package com.example.QuoraReactiveApp.service;

import com.example.QuoraReactiveApp.adapter.QuestionAdapter;
import com.example.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.example.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.example.QuoraReactiveApp.events.ViewCountEvent;
import com.example.QuoraReactiveApp.models.Question;
import com.example.QuoraReactiveApp.models.QuestionElasticDocument;
import com.example.QuoraReactiveApp.producers.KafkaEventProducer;
import com.example.QuoraReactiveApp.repositories.QuestionDocumentRepository;
import com.example.QuoraReactiveApp.repositories.QuestionRepository;
import com.example.QuoraReactiveApp.service.impl.IQuestionIndexService;
import com.example.QuoraReactiveApp.service.impl.IQuestionService;
import com.example.QuoraReactiveApp.util.CursorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;
    private final KafkaEventProducer kafkaEventProducer;
    private final IQuestionIndexService questionIndexService;
    private final QuestionDocumentRepository questionDocumentRepository;

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .tags(questionRequestDTO.getTags())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        //Datais store in mongo db and it will emit or return the mono of dto
        return questionRepository.save(question)
                .map(savedQuestion -> {
                    questionIndexService.createQuestionIndex(savedQuestion);  //dumping the question to elasticSearch
                    return QuestionAdapter.toQuestionResponseDTO(savedQuestion);
                })
                .doOnSuccess(res -> System.out.println("Question created successfully : " + res))
                .doOnError(error -> System.out.println("Error creating questions " + error));
    }

    @Override
    public Mono<QuestionResponseDTO> getQuestionById(String id) {
        return questionRepository.findById(id)
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnError(error-> System.out.println("Error fetching question: " + error))
                .doOnSuccess(response ->{
                    System.out.println("Question fetched successfully: " + response);
                    ViewCountEvent viewCountEvent = new ViewCountEvent(id,"question", LocalDateTime.now());
                    kafkaEventProducer.publishViewCountEvent(viewCountEvent);
                });
    }

    @Override
    public Flux<QuestionResponseDTO> getAllQuestions() {
        return questionRepository.findAll()
                .switchIfEmpty(Mono.error(
                        new RuntimeException("No Data Found.")))
                .map(QuestionAdapter::toQuestionResponseDTO);
    }

    @Override
    public Mono<Void> deleteQuestionById(String id) {
        return questionRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new RuntimeException("Question not found with id : " + id)))
                .flatMap(questionRepository::delete);
    }

    @Override
    public Flux<QuestionResponseDTO> searchQuestion(String query, int page, int size) {
        Pageable pageRequest = PageRequest.of(page,size);
        return questionRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
                query,pageRequest
        ).map(QuestionAdapter::toQuestionResponseDTO)
                .doOnError(error-> System.out.println("Error Searching questions: " + error))
                .doOnComplete(() -> System.out.println("Data Searched successfully."));
    }

    @Override
    public Flux<QuestionResponseDTO> getQuestionTag(String tag, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        return questionRepository.findByTagsContainingIgnoreCase(tag,pageable)
                .map(QuestionAdapter::toQuestionResponseDTO);
    }

    @Override
    public Flux<QuestionResponseDTO> fetchQuestion(String tag,String cursor, int size) {

        Pageable pageable = PageRequest.of(0,size);
        if(!CursorUtil.isValidCursor(cursor)){
            return questionRepository.findFirstBatchByTag(tag)
                    .take(size)
                    .map(QuestionAdapter::toQuestionResponseDTO)
                    .doOnError(error-> System.out.println("Error Searching questions: " + error))
                    .doOnComplete(() -> System.out.println("Data Searched successfully."));
        }else{
            LocalDateTime cursorTimeStamp = CursorUtil.parseCursor(cursor);
            return questionRepository.findNextBatchByTag(tag,cursorTimeStamp)
                    .take(size)
                    .map(QuestionAdapter::toQuestionResponseDTO)
                    .doOnError(error-> System.out.println("Error Searching questions: " + error))
                    .doOnComplete(() -> System.out.println("Data Searched successfully."));
        }
    }

    public List<QuestionElasticDocument> searchQuestionByElasticSearch(String query){
        return questionDocumentRepository.findByTitleContainingOrContentContaining(query,query);
    }
}
