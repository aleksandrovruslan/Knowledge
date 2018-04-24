package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
    Quiz getById(long id);
}
