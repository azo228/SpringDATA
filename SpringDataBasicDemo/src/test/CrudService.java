package com.example.springdatabasicdemo.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    T register (T entity);

    void deleteById(ID id);

    void delete (T entity);

    List<T> getAll();

    Optional<T> getById(ID id);
}
