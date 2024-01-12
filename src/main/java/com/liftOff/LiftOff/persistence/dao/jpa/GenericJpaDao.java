package com.liftOff.LiftOff.persistence.dao.jpa;
import com.liftOff.LiftOff.persistence.model.Model;
import com.liftOff.LiftOff.persistence.dao.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

// generic implementation of a Data Access Object (DAO) using Java Persistence API (JPA) for CRUD operations on entities
public abstract class GenericJpaDao<T extends Model> implements Dao<T> {
    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;


    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> findAll() {
        return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();
    }


    @Override
    public T findById(Integer id) {
        return em.find(modelType, id);
    }


    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }


    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}
