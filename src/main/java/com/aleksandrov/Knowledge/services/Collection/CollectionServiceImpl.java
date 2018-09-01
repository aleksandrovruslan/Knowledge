package com.aleksandrov.Knowledge.services.Collection;

import com.aleksandrov.Knowledge.exceptions.Collection.CollectionNotFoundException;
import com.aleksandrov.Knowledge.models.Collection;
import com.aleksandrov.Knowledge.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public Collection getCollection(long id) {
        return findCollection(id);
    }

    @Override
    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(long id) {
        findCollection(id);
        collectionRepository.deleteById(id);
    }

    @Override
    public Collection edit(Collection collection, long id) {
        Collection baseCollection = findCollection(collection.getId());
        baseCollection.setName(collection.getName());
        baseCollection.setQuizzes(collection.getQuizzes());
        return collectionRepository.save(collection);
    }

    @Override
    public Iterable<Collection> getCollections() {
        return collectionRepository.findAll();
    }

    private Collection findCollection(long id) {
        return collectionRepository.findById(id).orElseThrow(() ->
                new CollectionNotFoundException("Collection id " + id + " not found."));
    }
}
