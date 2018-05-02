package com.aleksandrov.Knowledge.services.CollectionType;

import com.aleksandrov.Knowledge.models.CollectionType;

import java.util.List;

public interface CollectionTypeService {
    CollectionType getCollectionType(int id);
    CollectionType saveRole(CollectionType collectionType);
    void deleteCollectionType(int id);
    CollectionType edit(CollectionType collectionType);
    List<CollectionType> getCollectionTypes();
}
