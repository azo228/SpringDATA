package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand",cascade = CascadeType.REMOVE)
    private List<Model> model;

    protected Brand() {
    }



}
