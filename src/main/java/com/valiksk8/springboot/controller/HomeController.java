package com.valiksk8.springboot.controller;

import com.valiksk8.springboot.dao.CategoryRepository;
import com.valiksk8.springboot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        return Optional.of(categoryRepository.findAll())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
