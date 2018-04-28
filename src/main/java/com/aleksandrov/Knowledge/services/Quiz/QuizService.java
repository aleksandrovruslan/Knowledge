package com.aleksandrov.Knowledge.services.Quiz;

import com.aleksandrov.Knowledge.models.Quiz;

public interface QuizService {
    Quiz getQuiz(long id);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuiz(long id);
    Iterable<Quiz> getQuizzes();
}
