package com.askend.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FilterCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String description;
    private String filterValue;

    @ManyToOne
    @JoinColumn(name = "filter_id", nullable = false)
    @JsonIgnore
    private Filter filter;
}
