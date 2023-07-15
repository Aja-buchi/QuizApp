package com.bujubanton.quiz.app.services;

import com.bujubanton.quiz.app.models.Question;
import com.bujubanton.quiz.app.models.QuestionDao;
import com.bujubanton.quiz.app.models.Quiz;
import com.bujubanton.quiz.app.repositories.QuestionRepository;
import com.bujubanton.quiz.app.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        try {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to create quiz", HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity <List<QuestionDao>> getQuizQuestions(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionDao> questionsForUsers = new ArrayList<>();
        for (Question q: questionsFromDB) {
            QuestionDao qw = new QuestionDao(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }
}
