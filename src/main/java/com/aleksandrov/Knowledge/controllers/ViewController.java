package com.aleksandrov.Knowledge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ViewController {

    @RequestMapping({"", "/", "/home", "/index.html"})
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping("/collections")
    public String collections(Map<String, Object> model) {
        return "collections";
    }

    @RequestMapping("/collections/list")
    public String collectionsList(Map<String, Object> model) {
        return "collections_list";
    }

    @RequestMapping("/collections/search")
    public String collectionsSearch(Map<String, Object> model) {
        return "collections_search";
    }

    @RequestMapping("/words")
    public String words(Map<String, Object> model) {
        return "words";
    }

    @RequestMapping("/words/list")
    public String wordsList(Map<String, Object> model) {
        return "words_list";
    }

    @RequestMapping("/words/search")
    public String wordsSearch(Map<String, Object> model) {
        return "words_search";
    }

    @RequestMapping("/quizzes")
    public String quizzes(Map<String, Object> model) {
        return "quizzes";
    }

    @RequestMapping("/quizzes/list")
    public String quizzesList(Map<String, Object> model) {
        return "quizzes_list";
    }

    @RequestMapping("/quizzes/search")
    public String quizzesSearch(Map<String, Object> model) {
        return "quizzes_search";
    }
}
