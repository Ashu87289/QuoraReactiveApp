package com.example.QuoraReactiveApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedResponseDTO {

    private List<QuestionResponseDTO> items;
    private String nextCursor;
    private boolean hasMore;
}
