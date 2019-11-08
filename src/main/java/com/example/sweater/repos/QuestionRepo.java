package com.example.sweater.repos;

import com.example.sweater.domain.Lecture;
import com.example.sweater.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    Question findByQuestionName(String questionName);
}
