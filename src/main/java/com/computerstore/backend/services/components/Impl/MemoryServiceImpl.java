package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.Memory;
import com.computerstore.backend.repositories.components.MemoryRepository;
import com.computerstore.backend.services.components.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryRepository repository;

    @Override
    public Memory create(Memory entity) {
        return repository.save(entity);
    }

    @Override
    public  Memory readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< Memory> readAll() {
        Iterable< Memory> result = repository.findAll();
        return result;
    }

    @Override
    public  Memory update( Memory entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( Memory entity) {
        repository.delete(entity);
    }
}
