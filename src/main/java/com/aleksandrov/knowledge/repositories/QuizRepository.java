package com.aleksandrov.knowledge.repositories;

import com.aleksandrov.knowledge.models.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
