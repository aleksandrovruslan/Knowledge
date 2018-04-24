package com.aleksandrov.Knowledge.services;

import com.aleksandrov.Knowledge.models.Collection;

public interface CollectionService {
    Collection getCollection(long id);
    Collection saveCollection(Collection collection);
    void deleteCollection(long id);
    Iterable<Collection> getCollections();
}
