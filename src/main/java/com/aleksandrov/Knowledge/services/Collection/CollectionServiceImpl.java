package com.aleksandrov.Knowledge.services.Collection;

import com.aleksandrov.Knowledge.exceptions.CollectionType.CollectionTypeNotFoundException;
import com.aleksandrov.Knowledge.models.Collection;
import com.aleksandrov.Knowledge.repositories.CollectionRepository;
import com.aleksandrov.Knowledge.services.Collection.CollectionService;
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
    public Collection edit(Collection collection) {
        findCollection(collection.getId());
        return collectionRepository.save(collection);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        collectionRepository.findAll().forEach(collection -> collections.add(collection));
        return collections;
    }

    private Collection findCollection(long id) {
        return collectionRepository.findById(id).orElseThrow(() ->
                new CollectionTypeNotFoundException("Collection id " + id + " not found."));
    }
}
