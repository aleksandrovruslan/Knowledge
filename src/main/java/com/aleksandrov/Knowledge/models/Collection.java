package com.aleksandrov.Knowledge.models;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false
            , cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private CollectionType type;

    @ManyToMany(mappedBy = "collections", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "collection_quizzes"
            , joinColumns = @JoinColumn(name = "collection_id")
            , inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private Set<Quiz> quizzes = new HashSet<>();

    public Collection() {
    }

    public Collection(String name, CollectionType type, Set<User> users, Set<Quiz> quizzes) {
        this.name = name;
        this.type = type;
        this.users = users;
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

    public CollectionType getType() {
        return type;
    }

    public void setType(CollectionType type) {
        this.type = type;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public String toString() {
        return "CollectionService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", quizzes=" + quizzes +
                '}';
    }
}
