package com.ra.service;

import java.util.List;

public interface IGeneric <T,ID>{
    List<T> findAll();

    Boolean create(T t);

    Boolean update(T t, ID id);

    T findById(ID id);

    void delete(ID id);

    Boolean login(T t);
}
