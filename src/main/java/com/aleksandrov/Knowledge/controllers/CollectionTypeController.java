package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.CollectionType;
import com.aleksandrov.Knowledge.services.CollectionType.CollectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collectiontype")
public class CollectionTypeController {
    @Autowired
    private CollectionTypeService collectionTypeService;

    @GetMapping("get/{id}")
    public CollectionType get(@PathVariable int id) {
        return collectionTypeService.getCollectionType(id);
    }

    @PostMapping("add/")
    public CollectionType add(@RequestBody CollectionType collectionType) {
        return collectionTypeService.saveRole(collectionType);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        collectionTypeService.deleteCollectionType(id);
    }

    @PutMapping("edit/")
    public CollectionType edit(@RequestBody CollectionType collectionType) {
        return collectionTypeService.edit(collectionType);
    }

    @GetMapping("list")
    public List<CollectionType> list() {
        return collectionTypeService.getCollectionTypes();
    }
}
