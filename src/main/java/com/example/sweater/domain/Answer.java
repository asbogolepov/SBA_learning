package com.example.sweater.domain;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Answer {
    public Answer() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Question question;
    private String selectedOption;

    public Answer(Question question, String selectedOption) {
        this.id = id;
        this.question = question;
        this.selectedOption = selectedOption;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

}
