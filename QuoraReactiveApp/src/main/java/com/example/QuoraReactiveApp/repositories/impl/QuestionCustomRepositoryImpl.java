package com.example.QuoraReactiveApp.repositories.impl;

import com.example.QuoraReactiveApp.models.Question;
import com.example.QuoraReactiveApp.repositories.QuestionCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
@RequiredArgsConstructor
public class QuestionCustomRepositoryImpl implements QuestionCustomRepository {

    private final ReactiveMongoTemplate mongoTemplate;
    @Override
    public Mono<Void> incrementViewCount(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));

        Update update = new Update().inc("viewcount",1);
        return mongoTemplate
                .updateFirst(query,update, Question.class)
                .then();
    }
}
