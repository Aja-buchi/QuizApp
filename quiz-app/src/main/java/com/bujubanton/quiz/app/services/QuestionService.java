package com.bujubanton.quiz.app.services;

import com.bujubanton.quiz.app.models.Question;
import com.bujubanton.quiz.app.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<List<Question>> getQuestionByCategory(String category){
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> addQuestion(Question question){
         questionRepository.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<Question> deleteById(Question question){
        try {
            return new ResponseEntity<>(questionRepository.deleteById(question), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(question, HttpStatus.BAD_REQUEST);
        }
    }
}
