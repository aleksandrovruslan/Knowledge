package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.QuizType;
import com.aleksandrov.Knowledge.services.QuizType.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiztype/")
public class QuizTypeController {
    @Autowired
    private QuizTypeService quizTypeService;

    @GetMapping("get/{id}")
    public QuizType get(@PathVariable int id) {
        return quizTypeService.getQuizType(id);
    }

    @PostMapping("add/")
    public QuizType add(@RequestBody QuizType quizType) {
        return quizTypeService.saveQuizType(quizType);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        quizTypeService.deleteQuizType(id);
    }

    @PutMapping("edit")
    public QuizType edit(@RequestBody QuizType quizType) {
        return quizTypeService.edit(quizType);
    }

    @GetMapping("list")
    public List<QuizType> list() {
        return quizTypeService.getQuizTypes();
    }
}
