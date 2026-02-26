package com.example.QuoraReactiveApp.repositories;


import reactor.core.publisher.Mono;

public interface QuestionCustomRepository {

    Mono<Void> incrementViewCount(String id);
}
