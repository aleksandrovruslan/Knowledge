package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.QuizType;
import org.springframework.data.repository.CrudRepository;

public interface QuizTypeRepository extends CrudRepository<QuizType, Integer> {
    QuizType getById(int id);
}
