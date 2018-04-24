package com.aleksandrov.Knowledge.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collection_types")
public class CollectionType implements Serializable {
    private static final long serialVersionUID = 8744069651265463940L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Collection> collections = new HashSet<>();

    public CollectionType() {
    }

    public CollectionType(String name, Set<Collection> collections) {
        this.name = name;
        this.collections = collections;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Collection> getCollections() {
        return collections;
    }

    public void setCollections(Set<Collection> collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "CollectionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
