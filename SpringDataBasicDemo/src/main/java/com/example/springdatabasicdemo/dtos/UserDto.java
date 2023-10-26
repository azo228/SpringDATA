package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.models.Offer;
import com.example.springdatabasicdemo.models.UserRole;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class UserDto {

    private Integer id;
    private String username;

    private String password;

    private String firstname;

    private String lastname;

    private Boolean isActive;

    private String imageUrl;


    private UserRoleDto userRole;

    private Date created;

    private Date modified;

    public UserDto(){
    }

    public UserDto(Integer id, String username, String password, String firstname, String lastname, Boolean isActive, String imageUrl, List<OfferDto> offer, UserRoleDto userRole, Date created, Date modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.userRole = userRole;
        this.created = created;
        this.modified = modified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public UserRoleDto getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDto userRole) {
        this.userRole = userRole;
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
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", userRole=" + userRole +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
