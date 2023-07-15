package com.bujubanton.quiz.app.repositories;

import com.bujubanton.quiz.app.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
//    ResponseEntity<String> createQuiz(String category, Integer numQ, String title);

}
