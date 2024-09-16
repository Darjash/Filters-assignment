package com.askend.assignment;

import com.askend.assignment.model.Filter;
import com.askend.assignment.repository.FilterRepository;
import com.askend.assignment.service.FilterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class FilterServiceTest {

    @Mock
    private FilterRepository filterRepository;

    @InjectMocks
    private FilterService filterService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllFilters_NoFilters() {
        when(filterRepository.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Filter>> response = filterService.getAllFilters();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testCreateFilter_Success() {
        Filter filter = new Filter();
        when(filterRepository.save(filter)).thenReturn(filter);

        ResponseEntity<Filter> response = filterService.createFilter(filter);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testDeleteFilter_FilterExists() {
        Long filterId = 1L;
        Filter filter = new Filter();
        when(filterRepository.findById(filterId)).thenReturn(Optional.of(filter));
        ResponseEntity<Filter> response = filterService.deleteFilter(filterId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetFilterById_FilterNotFound() {
        Long filterId = 1L;
        when(filterRepository.findById(filterId)).thenReturn(Optional.empty());
        ResponseEntity<Filter> response = filterService.getFilterById(filterId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
