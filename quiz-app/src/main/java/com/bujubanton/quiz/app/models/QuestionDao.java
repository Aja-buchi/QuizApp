package com.bujubanton.quiz.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDao {
    private Long id;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

//    public QuestionDao(Long id, String questiontitle, String option1, String option2, String option3, String option4) {
//        this.id = id;
//        this.questiontitle = questiontitle;
//        this.option1 = option1;
//        this.option2 = option2;
//        this.option3 = option3;
//        this.option4 = option4;
//    }
}
