package com.aleksandrov.knowledge.repositories;

import com.aleksandrov.knowledge.models.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
}
