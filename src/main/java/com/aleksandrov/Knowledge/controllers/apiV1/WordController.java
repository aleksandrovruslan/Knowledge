package com.aleksandrov.Knowledge.controllers.apiV1;

import com.aleksandrov.Knowledge.models.Word;
import com.aleksandrov.Knowledge.services.Word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping("/{id}")
    public Word get(@PathVariable long id) {
        return wordService.getWord(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Word word) {
        wordService.saveWord(word);
        return ResponseEntity.ok("resource saved");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        wordService.deleteWord(id);
        return ResponseEntity.ok("resource deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Word word, @PathVariable Long id) {
        wordService.editWord(word, id);
        return ResponseEntity.ok("resource saved");
    }

    @GetMapping("/list")
    public List<Word> list() {
        return wordService.getWords();
    }
}
