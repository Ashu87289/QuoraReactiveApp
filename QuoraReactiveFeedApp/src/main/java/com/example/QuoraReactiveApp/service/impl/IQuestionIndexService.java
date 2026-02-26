package com.example.QuoraReactiveApp.service.impl;

import com.example.QuoraReactiveApp.models.Question;
import com.example.QuoraReactiveApp.models.QuestionElasticDocument;
import reactor.core.publisher.Mono;

public interface IQuestionIndexService {
    void createQuestionIndex(Question question);
}
