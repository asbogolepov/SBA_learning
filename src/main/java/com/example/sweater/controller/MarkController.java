package com.example.sweater.controller;

import com.example.sweater.domain.Answer;
import com.example.sweater.domain.Lecture;
import com.example.sweater.domain.Question;
import com.example.sweater.domain.User;
import com.example.sweater.repos.AnswerRepo;
import com.example.sweater.repos.LectureRepo;
import com.example.sweater.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MarkController {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private LectureRepo lectureRepo;




}

