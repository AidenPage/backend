package com.computerstore.backend.services;

/**
 * Created by Aiden on 2016/10/23.
 */
public interface Service<E,ID>{
    E create(E entity);

    E readById(ID id);

    Iterable<E> readAll();

    E update(E entity);

    void delete(E entity);
}
