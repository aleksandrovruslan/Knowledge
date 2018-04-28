package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.Word;
import com.aleksandrov.Knowledge.services.Word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word/")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping("get/{id}")
    public Word get(@PathVariable long id) {
        return wordService.getWord(id);
    }

    @PostMapping("add/")
    public Word add(@RequestBody Word word) {
        return wordService.saveWord(word);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id) {
        wordService.deleteWord(id);
    }

    @PutMapping("edit/")
    public Word edit(@RequestBody Word word) {
        return wordService.editWord(word);
    }

    @GetMapping("list")
    public List<Word> list() {
        return wordService.getWords();
    }
}
