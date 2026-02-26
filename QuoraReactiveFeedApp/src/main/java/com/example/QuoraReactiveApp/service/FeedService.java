package com.example.QuoraReactiveApp.service;

import com.example.QuoraReactiveApp.adapter.QuestionAdapter;
import com.example.QuoraReactiveApp.dto.FeedResponseDTO;
import com.example.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.example.QuoraReactiveApp.models.Question;
import com.example.QuoraReactiveApp.repositories.QuestionRepository;
import com.example.QuoraReactiveApp.service.impl.IFeedService;
import com.example.QuoraReactiveApp.util.CursorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService implements IFeedService {

    private final QuestionRepository questionRepository;

    @Override
    public Mono<FeedResponseDTO> getHomeFeed(List<String> tags, String cursor, int size) {
        List<String> safeTags = tags == null ? Collections.emptyList() : tags;
        boolean hasValidCursor = CursorUtil.isValidCursor(cursor);

        Flux<Question> source;
        if (safeTags.isEmpty()) {
            source = hasValidCursor
                    ? questionRepository.findRecentQuestionsBefore(CursorUtil.parseCursor(cursor))
                    : questionRepository.findRecentQuestions();
        } else {
            source = hasValidCursor
                    ? questionRepository.findRecentQuestionsByTagsBefore(safeTags, CursorUtil.parseCursor(cursor))
                    : questionRepository.findRecentQuestionsByTags(safeTags);
        }

        return source
                .take(size + 1L)
                .collectList()
                .map(questions -> toFeedResponse(questions, size));
    }

    private FeedResponseDTO toFeedResponse(List<Question> questions, int size) {
        boolean hasMore = questions.size() > size;
        List<Question> pageQuestions = hasMore ? questions.subList(0, size) : questions;
        List<QuestionResponseDTO> items = pageQuestions.stream()
                .map(QuestionAdapter::toQuestionResponseDTO)
                .toList();

        String nextCursor = null;
        if (hasMore && !pageQuestions.isEmpty()) {
            LocalDateTime lastCreatedAt = pageQuestions.get(pageQuestions.size() - 1).getCreatedAt();
            if (lastCreatedAt != null) {
                nextCursor = lastCreatedAt.toString();
            }
        }

        return FeedResponseDTO.builder()
                .items(items)
                .hasMore(hasMore)
                .nextCursor(nextCursor)
                .build();
    }
}
