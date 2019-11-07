package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "lectures")
public class Lecture {
    public Lecture() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lectureName;
    private String lectureContent;

    public Lecture(String lectureName, String lectureContent) {
        this.lectureName = lectureName;
        this.lectureContent = lectureContent;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureContent() { return lectureContent; }

    public void setLectureContent(String lectureContent) {
        this.lectureContent = lectureContent;
    }
}
