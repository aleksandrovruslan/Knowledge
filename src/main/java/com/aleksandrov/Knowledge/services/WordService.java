package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.Word;

public interface WordService {
    Word getWord(long id);
    Word saveWord(Word word);
    void deleteWord(long id);
    Iterable<Word> getWords();
}
