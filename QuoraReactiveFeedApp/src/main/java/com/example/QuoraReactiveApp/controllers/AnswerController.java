package com.example.QuoraReactiveApp.controllers;

import com.example.QuoraReactiveApp.service.impl.IAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final IAnswerService answerService;



}
