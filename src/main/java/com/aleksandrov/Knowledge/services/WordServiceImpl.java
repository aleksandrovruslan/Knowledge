package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.Word;
import com.aleksandrov.Knowledge.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word getWord(long id) {
        return wordRepository.getById(id);
    }

    @Override
    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public void deleteWord(long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public Iterable<Word> getWords() {
        return wordRepository.findAll();
    }
}
