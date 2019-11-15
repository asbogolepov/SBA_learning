package com.example.sweater.repos;

import com.example.sweater.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    Optional<Answer> findById(Long id);
    Answer findByQuestionId(Long id);
}
