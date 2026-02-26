package com.example.QuoraReactiveApp.controllers;

import com.example.QuoraReactiveApp.dto.FeedResponseDTO;
import com.example.QuoraReactiveApp.service.impl.IFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

    private final IFeedService feedService;

    @GetMapping("/home")
    public Mono<FeedResponseDTO> getHomeFeed(
            @RequestParam(required = false) List<String> tags,
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int size
    ) {
        return feedService.getHomeFeed(tags, cursor, size);
    }
}
