package com.bujubanton.quiz.app.repositories;

import com.bujubanton.quiz.app.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
