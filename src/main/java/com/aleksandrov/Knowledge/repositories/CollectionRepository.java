package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.Collection;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Long> {
    Collection getById(long id);
}
