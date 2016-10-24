package com.computerstore.backend.services.peripherals.Impl;

import com.computerstore.backend.domain.peripherals.Mouse;
import com.computerstore.backend.repositories.peripherals.MouseRepository;
import com.computerstore.backend.services.peripherals.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class MouseServiceImpl implements MouseService {

    @Autowired
    private MouseRepository repository;

    @Override
    public Mouse create(Mouse entity) {
        return repository.save(entity);
    }

    @Override
    public Mouse readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Mouse> readAll() {
        Iterable<Mouse> result = repository.findAll();
        return result;
    }

    @Override
    public Mouse update(Mouse entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Mouse entity) {
        repository.delete(entity);
    }
}
