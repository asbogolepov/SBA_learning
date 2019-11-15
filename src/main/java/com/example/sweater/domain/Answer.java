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



    public Answer(Long questionId,String selectedOption) {
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

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

}
