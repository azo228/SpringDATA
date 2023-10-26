package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.enums.Role;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

    @Column(name = "name" ,nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole",cascade = CascadeType.REMOVE)
    private List<User> user;

    protected UserRole() {
    }
}
