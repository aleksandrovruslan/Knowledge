package com.aleksandrov.knowledge.services.Word;

import com.aleksandrov.knowledge.models.Word;

public interface WordService {
    Word getWord(long id);
    Word saveWord(Word word);
    void deleteWord(long id);
    Word editWord(Word word, long id);
    Iterable<Word> getWords();
}
