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
    private Long questionId;
    private String selectedOption;
    private boolean isRight;


    public Answer(Long questionId,String selectedOption, boolean isRight) {
        this.id = id;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
        this.isRight = isRight;
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
