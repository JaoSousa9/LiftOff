package com.liftOff.LiftOff.persistence.dao;

import com.liftOff.LiftOff.persistence.model.Model;

import java.util.List;

// Base interface for data access objects, provides methods to manage models

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);


    T saveOrUpdate(T modelObject);

    void delete(Integer id);
}

