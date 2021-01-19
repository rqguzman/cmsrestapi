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
}
