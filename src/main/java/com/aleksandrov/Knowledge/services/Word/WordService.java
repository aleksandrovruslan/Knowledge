package com.aleksandrov.Knowledge.services.Word;

import com.aleksandrov.Knowledge.models.Word;

import java.util.List;

public interface WordService {
    Word getWord(long id);
    Word saveWord(Word word);
    void deleteWord(long id);
    Word editWord(Word word, long id);
    List<Word> getWords();
}
