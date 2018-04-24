package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.QuizType;

public interface QuizTypeService {
    QuizType getQuizType(int id);
    QuizType saveQuizType(QuizType quizType);
    void deleteQuizType(int id);
    Iterable<QuizType> getQuizTypes();
}
