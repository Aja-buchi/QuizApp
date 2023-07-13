package com.bujubanton.quiz.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @GetMapping("allQuestions")
    public String getAllQuestions(){
        return ("Hello there!, here's all possible questions");
    }
}
