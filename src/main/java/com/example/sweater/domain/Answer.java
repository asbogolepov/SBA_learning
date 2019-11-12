package com.example.sweater.domain;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    public Answer() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String answerName;
    private int questionId;
    private String selectedOption;



    public Answer(int questionId, String answerName,String selectedOption) {
        this.id = id;
        this.questionId = questionId;
        this.answerName = answerName;
        this.selectedOption = selectedOption;
    }


    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }
}
