package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.Collection;
import com.aleksandrov.Knowledge.services.Collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection/")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping("get/{id}")
    public Collection get(@PathVariable long id) {
        return collectionService.getCollection(id);
    }

    @PostMapping("add/")
    public Collection add(@RequestBody Collection collection) {
        return collectionService.saveCollection(collection);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id) {
        collectionService.deleteCollection(id);
    }

    @PutMapping("edit/")
    public Collection edit(@RequestBody Collection collection) {
        return collectionService.edit(collection);
    }

    @GetMapping("list")
    public List<Collection> list() {
        return collectionService.getCollections();
    }
}
