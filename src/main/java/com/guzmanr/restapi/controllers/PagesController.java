package com.guzmanr.restapi.controllers;

import com.guzmanr.restapi.models.PageRepository;
import com.guzmanr.restapi.models.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pages", produces = "application/json")
@CrossOrigin(origins = "*")
public class PagesController {

    @Autowired
    private PageRepository repository;

    /*
     * There are better ways to implement this search (checking if pages is null for instance...)
     * Kept this way for educational purposes
     * */
    @GetMapping("/all")
    public Iterable<Page> pages() {

        List<Page> pages = repository.findAllByOrderBySortingAsc();
        return pages;
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Page> page(@PathVariable String slug) {

        Optional<Page> obj = repository.findBySlug(slug);

        if (obj.isPresent()) {
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
