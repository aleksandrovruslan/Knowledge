package com.aleksandrov.Knowledge.services.Collection;

import com.aleksandrov.Knowledge.models.Collection;

import java.util.List;

public interface CollectionService {
    Collection getCollection(long id);
    Collection saveCollection(Collection collection);
    void deleteCollection(long id);
    Collection edit(Collection collection);
    List<Collection> getCollections();
}
