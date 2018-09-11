package com.aleksandrov.knowledge.repositories;

import com.aleksandrov.knowledge.models.Collection;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Long> {
}
