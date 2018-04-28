package com.aleksandrov.Knowledge.services.Collection;

import com.aleksandrov.Knowledge.models.Collection;
import com.aleksandrov.Knowledge.repositories.CollectionRepository;
import com.aleksandrov.Knowledge.services.Collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public Collection getCollection(long id) {
        return collectionRepository.getById(id);
    }

    @Override
    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(long id) {
        collectionRepository.deleteById(id);
    }

    @Override
    public Iterable<Collection> getCollections() {
        return collectionRepository.findAll();
    }
}
