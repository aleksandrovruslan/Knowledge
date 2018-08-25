package com.aleksandrov.Knowledge.controllers.apiV1;

import com.aleksandrov.Knowledge.models.Collection;
import com.aleksandrov.Knowledge.services.Collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping("/{id}")
    public Collection get(@PathVariable long id) {
        return collectionService.getCollection(id);
    }

    @PostMapping("/")
    public Collection add(@RequestBody Collection collection) {
        return collectionService.saveCollection(collection);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        collectionService.deleteCollection(id);
    }

    @PutMapping("/{id}")
    public Collection edit(@RequestBody Collection collection, @PathVariable Long id) {
        return collectionService.edit(collection, id);
    }

    @GetMapping("/list")
    public List<Collection> list() {
        return collectionService.getCollections();
    }
}
