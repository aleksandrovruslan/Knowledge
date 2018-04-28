package com.aleksandrov.Knowledge.services.CollectionType;

import com.aleksandrov.Knowledge.models.CollectionType;
import com.aleksandrov.Knowledge.repositories.CollectionTypeRepository;
import com.aleksandrov.Knowledge.services.CollectionType.CollectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionTypeServiceImpl implements CollectionTypeService {
    @Autowired
    private CollectionTypeRepository collectionTypeRepository;

    @Override
    public CollectionType getCollectionType(int id) {
        return collectionTypeRepository.getById(id);
    }

    @Override
    public CollectionType saveRole(CollectionType collectionType) {
        return collectionTypeRepository.save(collectionType);
    }

    @Override
    public void deleteCollectionType(int id) {
        collectionTypeRepository.deleteById(id);
    }

    @Override
    public Iterable<CollectionType> getCollectionTypes() {
        return collectionTypeRepository.findAll();
    }
}
