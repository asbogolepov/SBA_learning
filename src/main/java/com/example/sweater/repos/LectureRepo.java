package com.example.sweater.repos;

import com.example.sweater.domain.Lecture;
import com.example.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepo extends JpaRepository<Lecture, Long> {
    Lecture findByLectureName(String lectureName);
}
