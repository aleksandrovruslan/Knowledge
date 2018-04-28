package com.aleksandrov.Knowledge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "words")
@JsonIgnoreProperties({"quizzes", "quizTranslations"})
public class Word implements Serializable {
    private static final long serialVersionUID = -7447129338242209985L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "question")
    private Set<Quiz> quizzes = new HashSet<>();

    @ManyToMany(mappedBy = "answers")
    private Set<Quiz> quizTranslations = new HashSet<>();

    public Word() {
    }

    public Word(Set<Quiz> quizzes, Set<Quiz> quizTranslations, String name) {
        this.quizzes = quizzes;
        this.quizTranslations = quizTranslations;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Set<Quiz> getQuizTranslations() {
        return quizTranslations;
    }

    public void setQuizTranslations(Set<Quiz> quizTranslations) {
        this.quizTranslations = quizTranslations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
