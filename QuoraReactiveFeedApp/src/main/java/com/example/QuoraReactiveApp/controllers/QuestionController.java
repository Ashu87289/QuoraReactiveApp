package com.example.QuoraReactiveApp.controllers;

import com.example.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.example.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.example.QuoraReactiveApp.models.QuestionElasticDocument;
import com.example.QuoraReactiveApp.service.impl.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id){
        return questionService.getQuestionById(id)
                .doOnError(err -> System.out.println("Error fetching questions: " + err))
                .doOnSuccess(response -> System.out.println("Questions fetched successfully: " + response));
    }

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO){
        //Process post request
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(res -> System.out.println("Question created successfully : " + res))
                .doOnError(error -> System.out.println("Error creating response :" + error));

    }

    @GetMapping
    public Flux<QuestionResponseDTO> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteQuestionById(@PathVariable String id){
        return questionService.deleteQuestionById(id);
    }


    @GetMapping("/search")
    public Flux<QuestionResponseDTO> searchQuestion(@RequestParam String query,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size){
        return questionService.searchQuestion(query,page,size);
    }

    @GetMapping("/fetch/{tag}")
    public Flux<QuestionResponseDTO> fetchQuestion(@PathVariable String tag,
                                                    @RequestParam(required = false) String cursor,
                                                   @RequestParam(defaultValue = "10") int size){
        return questionService.fetchQuestion(tag,cursor,size);
    }

    @GetMapping("/tag/{tag}")
    public Flux<QuestionResponseDTO> getQuestionTag(@PathVariable String tag,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size){
        return questionService.getQuestionTag(tag,page,size);
    }

    @GetMapping("/elasticSearch")
    public List<QuestionElasticDocument> searchQuestionElasticSearch(@RequestParam String query){
        return questionService.searchQuestionByElasticSearch(query);
    }
}
