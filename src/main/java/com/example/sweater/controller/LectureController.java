package com.example.sweater.controller;

import com.example.sweater.domain.Lecture;
import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LectureController {

    @Autowired
    private LectureRepo lectureRepo;

    @GetMapping("/lecture")
    public String lecture(Map<String, Object> model){
        Iterable<Lecture> lectures = lectureRepo.findAll();
        model.put("lectures", lectures);
        return "lecture";
    }

    @PostMapping("/lecture")
    public String addLecture(
            @AuthenticationPrincipal User user,
            @RequestParam String lectureName,
            @RequestParam String lectureContent, Map<String, Object> model) {
        Lecture lecture = new Lecture(lectureName, lectureContent);
        lectureRepo.save(lecture);

        Iterable<Lecture> lectures = lectureRepo.findAll();
        model.put("lectures", lectures);

        return "lecture";
    }
}

