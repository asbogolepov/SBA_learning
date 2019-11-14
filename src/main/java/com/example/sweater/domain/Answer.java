package com.example.sweater.domain;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    public Answer() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int questionId;
    private String selectedOption;



    public Answer(int questionId,String selectedOption) {
        this.id = id;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }


    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

}
