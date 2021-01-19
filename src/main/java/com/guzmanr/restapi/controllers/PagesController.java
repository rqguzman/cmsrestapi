package com.guzmanr.restapi.controllers;

import com.guzmanr.restapi.models.PageRepository;
import com.guzmanr.restapi.models.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
