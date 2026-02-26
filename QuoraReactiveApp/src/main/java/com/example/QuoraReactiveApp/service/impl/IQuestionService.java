package com.example.QuoraReactiveApp.service.impl;

import com.example.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.example.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.example.QuoraReactiveApp.models.QuestionElasticDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IQuestionService {

    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);

    public Mono<QuestionResponseDTO> getQuestionById(String id);

    public Flux<QuestionResponseDTO>  getAllQuestions();

    public Mono<Void> deleteQuestionById(String id);

    public Flux<QuestionResponseDTO>  searchQuestion(String query,int page,int size);

    public Flux<QuestionResponseDTO> getQuestionTag(String tag,int page,int size);

    public Flux<QuestionResponseDTO> fetchQuestion(String tag,String cursor,int size);


    List<QuestionElasticDocument> searchQuestionByElasticSearch(String query);
}
