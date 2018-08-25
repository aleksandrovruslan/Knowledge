package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
}
