package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.Quiz;
import com.aleksandrov.Knowledge.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("get/{id}")
    public Quiz get(@PathVariable long id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("add/")
    public Quiz add(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id) {
        quizService.deleteQuiz(id);
    }

    @PutMapping("edit/")
    public Quiz edit(@RequestBody Quiz quiz) {
        return quizService.edit(quiz);
    }

    @GetMapping("list")
    public List<Quiz> list() {
        return quizService.getQuizzes();
    }
}
