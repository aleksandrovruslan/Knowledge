package com.aleksandrov.Knowledge.services.CollectionType;

import com.aleksandrov.Knowledge.models.CollectionType;

public interface CollectionTypeService {
    CollectionType getCollectionType(int id);
    CollectionType saveRole(CollectionType collectionType);
    void deleteCollectionType(int id);
    Iterable<CollectionType> getCollectionTypes();
}
