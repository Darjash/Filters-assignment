package com.askend.assignment.service;

import com.askend.assignment.model.Filter;
import com.askend.assignment.model.FilterCriteria;
import com.askend.assignment.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    public ResponseEntity<List<Filter>> getAllFilters() {
        List<Filter> filters = filterRepository.findAll();
        if (filters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filters, HttpStatus.OK);
    }

    public ResponseEntity<Filter> createFilter(Filter filter) {
        try {
            if (filter.getCriteria() != null) {
                for (FilterCriteria criteria : filter.getCriteria()) {
                    criteria.setFilter(filter);
                }
            }
            Filter createdFilter = filterRepository.save(filter);
            return new ResponseEntity<>(createdFilter, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Filter> deleteFilter(Long id) {
        Optional<Filter> filter = filterRepository.findById(id);
        if(filter.isPresent()){
            filterRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Filter> getFilterById(Long id) {
        Optional<Filter> filter = filterRepository.findById(id);
        if (filter.isPresent()) {
            return new ResponseEntity<>(filter.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
