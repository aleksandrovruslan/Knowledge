package com.aleksandrov.knowledge.services.Collection;

import com.aleksandrov.knowledge.models.Collection;

public interface CollectionService {
    Collection getCollection(long id);
    Collection saveCollection(Collection collection);
    void deleteCollection(long id);
    Collection edit(Collection collection, long id);
    Iterable<Collection> getCollections();
}
