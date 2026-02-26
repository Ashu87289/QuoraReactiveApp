package com.example.QuoraReactiveApp.adapter;

import com.example.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.example.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.example.QuoraReactiveApp.models.Question;

public class QuestionAdapter {

    public static QuestionResponseDTO toQuestionResponseDTO(Question question){
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .tags(question.getTags())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
