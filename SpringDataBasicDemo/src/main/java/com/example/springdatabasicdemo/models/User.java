package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String firstname;

    @Column(name = "last_name",nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Boolean isActive;


    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Offer> offer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable=false)
    private UserRole userRole;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;

    protected User() {
    }


}
