package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.QuizType;
import com.aleksandrov.Knowledge.repositories.QuizTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizTypeServiceImpl implements QuizTypeService {
    @Autowired
    private QuizTypeRepository quizTypeRepository;

    @Override
    public QuizType getQuizType(int id) {
        return quizTypeRepository.getById(id);
    }

    @Override
    public QuizType saveQuizType(QuizType quizType) {
        return quizTypeRepository.save(quizType);
    }

    @Override
    public void deleteQuizType(int id) {
        quizTypeRepository.deleteById(id);
    }

    @Override
    public Iterable<QuizType> getQuizTypes() {
        return quizTypeRepository.findAll();
    }
}
