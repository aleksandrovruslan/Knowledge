package com.aleksandrov.Knowledge.services.QuizType;

import com.aleksandrov.Knowledge.models.QuizType;

import java.util.List;

public interface QuizTypeService {
    QuizType getQuizType(int id);
    QuizType saveQuizType(QuizType quizType);
    void deleteQuizType(int id);
    QuizType edit(QuizType quizType);
    List<QuizType> getQuizTypes();
}
