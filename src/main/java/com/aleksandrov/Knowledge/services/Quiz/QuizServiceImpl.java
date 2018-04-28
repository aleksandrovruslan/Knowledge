package com.aleksandrov.Knowledge.services.Quiz;

import com.aleksandrov.Knowledge.models.Quiz;
import com.aleksandrov.Knowledge.repositories.QuizRepository;
import com.aleksandrov.Knowledge.services.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz getQuiz(long id) {
        return quizRepository.getById(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Iterable<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }
}
