package com.example.QuoraReactiveApp.service.impl;

import com.example.QuoraReactiveApp.dto.LikeRequestDTO;
import com.example.QuoraReactiveApp.dto.LikeResponseDTO;
import reactor.core.publisher.Mono;

public interface ILikeService {

    Mono<LikeResponseDTO> createLike(LikeRequestDTO likeRequestDTO);

    Mono<LikeResponseDTO> countLikesByTargetIdAndTargetType(String targetId,String targetType);

    Mono<LikeResponseDTO> countDisLikesByTargetIdAndTargetType(String targetId,String targetType);

    Mono<LikeResponseDTO> toggleLike(String targetId,String targetType,Boolean isLike);

}
