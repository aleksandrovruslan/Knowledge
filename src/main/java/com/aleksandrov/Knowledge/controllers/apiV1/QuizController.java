package com.aleksandrov.Knowledge.controllers.apiV1;

import com.aleksandrov.Knowledge.models.Quiz;
import com.aleksandrov.Knowledge.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> add(@RequestBody Quiz quiz) {
        quizService.saveQuiz(quiz);
        return ResponseEntity.ok("resource saved");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok("resource deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Quiz quiz, @PathVariable Long id) {
        quizService.edit(quiz, id);
        return ResponseEntity.ok("resource changed");
    }

    @GetMapping("/list")
    public Iterable<Quiz> list() {
        return quizService.getQuizzes();
    }
}
