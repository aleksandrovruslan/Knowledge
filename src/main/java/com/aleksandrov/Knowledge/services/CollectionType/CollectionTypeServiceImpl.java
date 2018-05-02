package com.aleksandrov.Knowledge.services.CollectionType;

import com.aleksandrov.Knowledge.exceptions.CollectionType.CollectionTypeNotFoundException;
import com.aleksandrov.Knowledge.models.CollectionType;
import com.aleksandrov.Knowledge.repositories.CollectionTypeRepository;
import com.aleksandrov.Knowledge.services.CollectionType.CollectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionTypeServiceImpl implements CollectionTypeService {
    @Autowired
    private CollectionTypeRepository collectionTypeRepository;

    @Override
    public CollectionType getCollectionType(int id) {
        return findCollectionType(id);
    }

    @Override
    public CollectionType saveRole(CollectionType collectionType) {
        return collectionTypeRepository.save(collectionType);
    }

    @Override
    public void deleteCollectionType(int id) {
        findCollectionType(id);
        collectionTypeRepository.deleteById(id);
    }

    @Override
    public CollectionType edit(CollectionType collectionType) {
        findCollectionType(collectionType.getId());
        return collectionTypeRepository.save(collectionType);
    }

    @Override
    public List<CollectionType> getCollectionTypes() {
        List<CollectionType> collectionTypes = new ArrayList<>();
        collectionTypeRepository.findAll().forEach(collectionType -> collectionTypes.add(collectionType));
        return collectionTypes;
    }

    private CollectionType findCollectionType(int id) {
        return collectionTypeRepository.findById(id).orElseThrow(() ->
                new CollectionTypeNotFoundException("Collection type id " + id + " not found."));
    }
}
