package com.example.QuoraReactiveApp.service;

import com.example.QuoraReactiveApp.models.Question;
import com.example.QuoraReactiveApp.models.QuestionElasticDocument;
import com.example.QuoraReactiveApp.repositories.QuestionDocumentRepository;
import com.example.QuoraReactiveApp.service.impl.IQuestionIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionIndexService implements IQuestionIndexService{

    private final QuestionDocumentRepository questionDocumentRepository;
    @Override
    public void createQuestionIndex(Question question) {
        QuestionElasticDocument document = QuestionElasticDocument.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();
        questionDocumentRepository.save(document);
    }
}
