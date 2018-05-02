package com.aleksandrov.Knowledge.services.Word;

import com.aleksandrov.Knowledge.exceptions.Word.WordNotFoundException;
import com.aleksandrov.Knowledge.models.Word;
import com.aleksandrov.Knowledge.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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
    public Word editWord(Word word) {
        findWord(word.getId());
        return saveWord(word);
    }

    @Override
    public List<Word> getWords() {
        List<Word> words = new LinkedList<>();
        wordRepository.findAll().forEach(word -> words.add(word));
        return words;
    }

    private Word findWord(long id) {
        return wordRepository.findById(id).orElseThrow(() ->
                new WordNotFoundException("Word id " + id + " not found."));
    }
}
