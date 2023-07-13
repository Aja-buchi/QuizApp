package com.bujubanton.quiz.app.services;

import com.bujubanton.quiz.app.models.Question;
import com.bujubanton.quiz.app.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
         return questionRepository.findAll();
    }
}
