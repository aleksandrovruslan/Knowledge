package com.aleksandrov.Knowledge.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quizzes")
public class Quiz implements Serializable {
    private static final long serialVersionUID = 7644077023940551370L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false
            , cascade = {CascadeType.ALL}
            , fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_type_id")
    private QuizType quizType;

    @ManyToOne(optional = false
            , cascade = {CascadeType.ALL}
            , fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Word question;

    @ManyToMany(fetch = FetchType.LAZY
            , cascade = {CascadeType.ALL})
    @JoinTable(name = "quiz_answers",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Set<Word> answers = new HashSet<>();

    @ManyToMany(mappedBy = "quizzes")
    private Set<Collection> collections = new HashSet<>();

    public Quiz() {
    }

    public Quiz(QuizType quizType, Word question
            , Set<Word> answers, Set<Collection> collections) {
        this.quizType = quizType;
        this.question = question;
        this.answers = answers;
        this.collections = collections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public Word getQuestion() {
        return question;
    }

    public void setQuestion(Word question) {
        this.question = question;
    }

    public Set<Word> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Word> answers) {
        this.answers = answers;
    }

    public Set<Collection> getCollections() {
        return collections;
    }

    public void setCollections(Set<Collection> collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", quizType=" + quizType +
                ", question=" + question +
                ", answers=" + answers +
                '}';
    }
}
