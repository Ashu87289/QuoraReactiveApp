package com.example.QuoraReactiveApp.service.impl;

import com.example.QuoraReactiveApp.dto.FeedResponseDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IFeedService {

    Mono<FeedResponseDTO> getHomeFeed(List<String> tags, String cursor, int size);
}
