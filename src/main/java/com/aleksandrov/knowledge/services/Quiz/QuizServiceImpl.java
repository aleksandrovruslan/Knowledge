package com.aleksandrov.knowledge.services.Quiz;

import com.aleksandrov.knowledge.exceptions.Collection.CollectionNotFoundException;
import com.aleksandrov.knowledge.exceptions.Quiz.QuizNotFoudException;
import com.aleksandrov.knowledge.models.Collection;
import com.aleksandrov.knowledge.models.Quiz;
import com.aleksandrov.knowledge.repositories.CollectionRepository;
import com.aleksandrov.knowledge.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public Quiz getQuiz(long id) {
        return findQuiz(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        Quiz quizSaved = quizRepository.save(quiz);
        quiz.getCollections().forEach((c) -> {
            Collection collection = collectionRepository.findById(c.getId())
                    .orElseThrow(() -> new CollectionNotFoundException
                            ("Collection id " + c.getId() + " not found."));
            collection.getQuizzes().add(quizSaved);
            collectionRepository.save(collection);
        });
        return quizSaved;
    }

    @Override
    public void deleteQuiz(long id) {
        findQuiz(id);
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz edit(Quiz quiz, long id) {
        Quiz baseQuiz = findQuiz(quiz.getId());
        baseQuiz.setQuestion(quiz.getQuestion());
        baseQuiz.setAnswers(quiz.getAnswers());
        return quizRepository.save(baseQuiz);
    }

    @Override
    public Iterable<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

    private Quiz findQuiz(long id) {
        return quizRepository.findById(id).orElseThrow(() ->
                new QuizNotFoudException("Quiz id " + id + " not found."));
    }
}
