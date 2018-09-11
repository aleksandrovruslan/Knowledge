package com.aleksandrov.knowledge.controllers.apiV1;

import com.aleksandrov.knowledge.models.Collection;
import com.aleksandrov.knowledge.services.Collection.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> add(@RequestBody Collection collection) {
        collectionService.saveCollection(collection);
        return ResponseEntity.ok("resource saved");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        collectionService.deleteCollection(id);
        return ResponseEntity.ok("resource deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Collection collection, @PathVariable Long id) {
        collectionService.edit(collection, id);
        return ResponseEntity.ok("resource changed");
    }

    @GetMapping("/list")
    public Iterable<Collection> list() {
        return collectionService.getCollections();
    }
}
