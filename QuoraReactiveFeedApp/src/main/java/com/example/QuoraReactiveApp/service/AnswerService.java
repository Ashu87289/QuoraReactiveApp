package com.example.QuoraReactiveApp.service;

import com.example.QuoraReactiveApp.dto.AnswerRequestDTO;
import com.example.QuoraReactiveApp.dto.AnswerResponseDTO;
import com.example.QuoraReactiveApp.service.impl.IAnswerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnswerService implements IAnswerService {

    @Override
    public Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO) {
        return null;
    }

    @Override
    public Mono<AnswerResponseDTO> getAnswerById(String id) {
        return null;
    }

    @Override
    public Mono<AnswerResponseDTO> updateAnswer(String id, AnswerRequestDTO answerRequestDTO) {
        return null;
    }

    @Override
    public Mono<Void> deleteAnswer(String id) {
        return null;
    }

    @Override
    public Flux<AnswerResponseDTO> getAllAnswers() {
        return null;
    }

    @Override
    public Flux<AnswerResponseDTO> getAnswersByQuestionId(String questionId) {
        return null;
    }

    @Override
    public Mono<Long> getAnswerCountByQuestionId(String questionId) {
        return null;
    }

    @Override
    public Flux<AnswerResponseDTO> getAnswersByQuestionIdOrderByCreatedAtDesc(String questionId) {
        return null;
    }

    @Override
    public Flux<AnswerResponseDTO> getAnswersByQuestionIdOrderByCreatedAtAsc(String questionId) {
        return null;
    }
}
