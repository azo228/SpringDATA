package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enums.Engine;
import com.example.springdatabasicdemo.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Engine engine;

    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Transmission transmission;

    @Column(nullable = false)
    private Integer year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    private Model model;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable=false)
    private User user;

    protected Offer() {
    }

}
