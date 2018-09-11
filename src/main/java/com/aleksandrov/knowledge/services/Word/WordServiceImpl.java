package com.aleksandrov.knowledge.services.Word;

import com.aleksandrov.knowledge.exceptions.Word.WordNotFoundException;
import com.aleksandrov.knowledge.models.Word;
import com.aleksandrov.knowledge.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word getWord(long id) {
        return findWord(id);
    }

    @Override
    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public void deleteWord(long id) {
        findWord(id);
        wordRepository.deleteById(id);
    }

    @Override
    public Word editWord(Word word, long id) {
        Word baseWord = findWord(id);
        baseWord.setName(word.getName());
        return saveWord(baseWord);
    }

    @Override
    public Iterable<Word> getWords() {
        return wordRepository.findAll();
    }

    private Word findWord(long id) {
        return wordRepository.findById(id).orElseThrow(() ->
                new WordNotFoundException("Word id " + id + " not found."));
    }
}
