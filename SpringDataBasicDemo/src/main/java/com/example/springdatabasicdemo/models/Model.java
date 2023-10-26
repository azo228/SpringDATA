package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enums.Category;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Column(name="image_url",nullable = false)
    private String imageUrl ;

    @Column(name="start_year",nullable = false)
    private Integer startYear ;

    @Column(name="end_year",nullable = false)
    private Integer endYear ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model",cascade = CascadeType.REMOVE)
    private List<Offer> offer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    private Brand brand;

    protected Model() {
    }
}
