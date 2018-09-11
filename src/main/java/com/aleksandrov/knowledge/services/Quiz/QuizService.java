package com.aleksandrov.knowledge.services.Quiz;

import com.aleksandrov.knowledge.models.Quiz;

public interface QuizService {
    Quiz getQuiz(long id);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuiz(long id);
    Quiz edit(Quiz quiz, long id);
    Iterable<Quiz> getQuizzes();
}
