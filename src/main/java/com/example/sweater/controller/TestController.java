package com.example.sweater.controller;

import com.example.sweater.domain.*;
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
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private LectureRepo lectureRepo;

    @GetMapping("/add-questions")
    public String showQuestions(Map<String, Object> model){
        Iterable<Question> questions = questionRepo.findAll();
        model.put("questions", questions);
        return "add-questions";
    }

    @PostMapping("/add-questions")
    public String addQuestion(
            @AuthenticationPrincipal User user,
            @RequestParam String questionName,
            @RequestParam String optionOne,
            @RequestParam String optionTwo,
            @RequestParam String optionThree,
            @RequestParam String optionFour,
            @RequestParam Long lectureId,
            @RequestParam String rightAnswer, Map<String, Object> model) {
        Question question = new Question(questionName, optionOne, optionTwo, optionThree, optionFour, lectureId, rightAnswer);
        questionRepo.save(question);

        Iterable<Question> questions = questionRepo.findAll();
        model.put("questions", questions);

        return "add-questions";
    }

    @GetMapping("/test")
    public String question(Map<String, Object> model){
        Iterable<Question> questions = questionRepo.findAll();
        Iterable<Answer> answers = answerRepo.findAll();
        model.put("questions", questions);
        model.put("answers", answers);
        return "test";
    }

    @PostMapping("/test")
    public String makeAnswer(
            @RequestParam String selectedOption,
            @RequestParam("questionId") Question question,
            Map<String, Object> model
            ) {

        Iterable<Question> questions = questionRepo.findAll();
        Iterable<Answer> answers = answerRepo.findAll();
        boolean isRight = question.compareAnswer(selectedOption);
        Answer answer = new Answer(question.getId(), selectedOption, isRight);
        answer.setRight(question.compareAnswer(selectedOption ));
        Lecture lecture = lectureRepo.getOne(question.getLectureId());
        model.put("questions", questions);
        model.put("answers", answers);
        model.put("answer", answer);
        model.put("lecture", lecture);
        answerRepo.save(answer);
        return "test";
    }

}

