package com.guzmanr.restapi.controllers;

import com.guzmanr.restapi.models.PageRepository;
import com.guzmanr.restapi.models.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin/pages", produces = "application/json")
@CrossOrigin(origins = "*")
public class AdminPagesController {

    @Autowired
    private PageRepository repository;

    @GetMapping
    public Iterable<Page> index() {

        List<Page> pages = repository.findAllByOrderBySortingAsc();
        return pages;
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Page add(@RequestBody Page page) {
        return repository.save(page);
    }

    @GetMapping(path = "/edit/{id}")
    public ResponseEntity<Page> edit(@PathVariable int id){

        Optional<Page> page = repository.findById(id);
        return new ResponseEntity<>(page.get(), HttpStatus.OK);
    }

    @PutMapping(path = "/edit")
    public Page put(@RequestBody Page page){

        return repository.save(page);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }

    }
}
