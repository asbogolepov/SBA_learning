package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "marks")

public class Mark {
    public Mark(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int mark;
    private int correctAnswers;
    private int questionsAmount;

    public Mark(Long id, int correctAnswers, int questionsAmount){
        this. id = id;
        this.correctAnswers = correctAnswers;
        this.questionsAmount = questionsAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getQuestionsAmount() {
        return questionsAmount;
    }

    public void setQuestionsAmount(int questionsAmount) {
        this.questionsAmount = questionsAmount;
    }
}
