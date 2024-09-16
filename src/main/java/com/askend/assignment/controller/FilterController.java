package com.askend.assignment.controller;

import com.askend.assignment.model.Filter;
import com.askend.assignment.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filters")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class FilterController {
    @Autowired
    private FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Filter>> getAllFilters() {
        return filterService.getAllFilters();
    }

    @GetMapping("getFilter/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Long id){
        return filterService.getFilterById(id);
    }

    @PostMapping("add")
    public ResponseEntity<Filter> createFilter(@RequestBody Filter filter) {
        return filterService.createFilter(filter);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Filter> deleteFilter(@PathVariable Long id) {
        return filterService.deleteFilter(id);
    }
}
