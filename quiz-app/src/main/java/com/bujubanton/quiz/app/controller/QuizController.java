package com.bujubanton.quiz.app.controller;

import com.bujubanton.quiz.app.models.QuestionDao;
import com.bujubanton.quiz.app.models.Response;
import com.bujubanton.quiz.app.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity <List<QuestionDao>> getQuizQuestions(@PathVariable Long id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuestion(@PathVariable Integer id, @PathVariable List<Response> responses){
        return quizService.calcResult(id, responses);
    }
}
