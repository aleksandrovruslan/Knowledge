package com.aleksandrov.knowledge.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collections")
public class Collection implements Serializable {
    private static final long serialVersionUID = 5408511143352613612L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "collection_quizzes"
            , joinColumns = @JoinColumn(name = "collection_id")
            , inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private Set<Quiz> quizzes = new HashSet<>();

    public Collection() {
    }

    public Collection(String name, Set<Quiz> quizzes) {
        this.name = name;
        this.quizzes = quizzes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quizzes=" + quizzes +
                '}';
    }
}
