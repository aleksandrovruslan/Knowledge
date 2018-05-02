package com.aleksandrov.Knowledge.services.Quiz;

import com.aleksandrov.Knowledge.models.Quiz;

import java.util.List;

public interface QuizService {
    Quiz getQuiz(long id);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuiz(long id);
    Quiz edit(Quiz quiz);
    List<Quiz> getQuizzes();
}
