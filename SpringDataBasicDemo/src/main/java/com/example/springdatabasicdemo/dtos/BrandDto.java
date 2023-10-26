package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Model;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class BrandDto {

    private Integer id;
    private String name;

    private Date created;

    private Date modified;


    public BrandDto(){
    }

    public BrandDto(Integer id, String name, Date created, Date modified, List<ModelDto> model) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
