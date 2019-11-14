package com.example.sweater.controller;

import com.example.sweater.domain.*;
import com.example.sweater.domain.Lecture;
import com.example.sweater.repos.AnswerRepo;
import com.example.sweater.repos.LectureRepo;
import com.example.sweater.repos.QuestionRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

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
            @RequestParam int lectureId,
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
            @AuthenticationPrincipal User user,
            @RequestParam String selectedOption,  Map<String, Object> model) {
        Question question = new Question();
        Answer answer = new Answer(question.getId(), selectedOption);
        answer.setSelectedOption(selectedOption);
        question.compareAnswer(answer.getSelectedOption());
        answerRepo.save(answer);
        Iterable<Answer> answers = answerRepo.findAll();
        model.put("answers", answers);
        return "test";
    }
}

