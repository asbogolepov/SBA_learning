package com.example.sweater.controller;

import com.example.sweater.domain.*;
import com.example.sweater.repos.AnswerRepo;
import com.example.sweater.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

//    @GetMapping("/test")
//    public String question(@PathVariable Question question, Model model){
//        model.addAttribute("question", question);
//        return "test";
//    }

    @PostMapping("/test")
    public String makeAnswer(
            @RequestParam Map<String, String> form,
            @RequestParam String selectedOption,

            @RequestParam("questionId") Question question, Map<String, Object> model
            ) {
        Iterable<Question> questions = questionRepo.findAll();
        boolean isRight = Question.compareAnswer(question, selectedOption);
        model.put("questions", questions);
        return "test";
    }

//    @PostMapping("/test")
//    public String makeAnswer(@RequestParam("questionId") Question question, @RequestParam String selectedOption, Model model, @RequestParam("questionId") Answer answer) {
//        answer.setSelectedOption(selectedOption);
//        boolean isRight = question.compareAnswer(answer);
//        Iterable<Answer> answers = answerRepo.findAll();
//        model.addAttribute("answers", answers);
//        return "test";
//    }
}

