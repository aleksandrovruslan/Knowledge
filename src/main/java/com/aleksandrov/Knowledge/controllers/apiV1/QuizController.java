package com.aleksandrov.Knowledge.controllers.apiV1;

import com.aleksandrov.Knowledge.models.Quiz;
import com.aleksandrov.Knowledge.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/{id}")
    public Quiz get(@PathVariable long id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/")
    public Quiz add(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        quizService.deleteQuiz(id);
    }

    @PutMapping("/{id}")
    public Quiz edit(@RequestBody Quiz quiz, @PathVariable Long id) {
        return quizService.edit(quiz, id);
    }

    @GetMapping("/list")
    public List<Quiz> list() {
        return quizService.getQuizzes();
    }
}
