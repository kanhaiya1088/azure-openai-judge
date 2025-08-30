package com.cvs.azureopenai.controller;

import com.cvs.azureopenai.service.JudgeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/judge", produces = MediaType.APPLICATION_JSON_VALUE)
public class JudgeController {

    private final JudgeService judgeService;

    public JudgeController(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @PostMapping
    public String judgePrompt(@RequestBody String prompt) {
        return judgeService.analyze(prompt);
    }
}