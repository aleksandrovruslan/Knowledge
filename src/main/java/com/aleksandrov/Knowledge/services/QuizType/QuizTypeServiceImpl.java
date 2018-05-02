package com.aleksandrov.Knowledge.services.QuizType;

import com.aleksandrov.Knowledge.exceptions.QuizType.QuizTypeNotFoundException;
import com.aleksandrov.Knowledge.models.QuizType;
import com.aleksandrov.Knowledge.repositories.QuizTypeRepository;
import com.aleksandrov.Knowledge.services.QuizType.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizTypeServiceImpl implements QuizTypeService {
    @Autowired
    private QuizTypeRepository quizTypeRepository;

    @Override
    public QuizType getQuizType(int id) {
        return findQuizType(id);
    }

    @Override
    public QuizType saveQuizType(QuizType quizType) {
        return quizTypeRepository.save(quizType);
    }

    @Override
    public void deleteQuizType(int id) {
        findQuizType(id);
        quizTypeRepository.deleteById(id);
    }

    @Override
    public QuizType edit(QuizType quizType) {
        findQuizType(quizType.getId());
        return quizTypeRepository.save(quizType);
    }

    @Override
    public List<QuizType> getQuizTypes() {
        List<QuizType> quizTypes = new ArrayList<>();
        quizTypeRepository.findAll().forEach(quizType -> quizTypes.add(quizType));
        return quizTypes;
    }

    private QuizType findQuizType(int id) {
        return quizTypeRepository.findById(id).orElseThrow(() ->
                new QuizTypeNotFoundException("Quiz type id " + id + " not found."));
    }
}
