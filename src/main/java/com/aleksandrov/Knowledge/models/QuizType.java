package com.aleksandrov.Knowledge.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz_type")
public class QuizType implements Serializable {
    private static final long serialVersionUID = -5867857433311624974L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "quizType")
    private Set<Quiz> quizzes = new HashSet<>();

    public QuizType() {
    }

    public QuizType(String name) {
        this.name = name;
    }

    public QuizType(String name, Set<Quiz> quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public String toString() {
        return "QuizType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
