package com.example.sweater.repos;

import com.example.sweater.domain.Answer;
import com.example.sweater.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    Answer findById(int id);
    Answer findByQuestionId(Long id);
}
