package com.aleksandrov.Knowledge.repositories;

import com.aleksandrov.Knowledge.models.CollectionType;
import org.springframework.data.repository.CrudRepository;

public interface CollectionTypeRepository extends CrudRepository<CollectionType, Integer> {
    CollectionType getById(int id);
}
