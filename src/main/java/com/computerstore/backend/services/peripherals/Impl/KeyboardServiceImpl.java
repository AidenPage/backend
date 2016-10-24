package com.computerstore.backend.services.peripherals.Impl;

import com.computerstore.backend.domain.peripherals.Keyboard;
import com.computerstore.backend.repositories.peripherals.KeyboardRepository;
import com.computerstore.backend.services.peripherals.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class KeyboardServiceImpl implements KeyboardService {

    @Autowired
    private KeyboardRepository repository;

    @Override
    public Keyboard create(Keyboard entity) {
        return repository.save(entity);
    }

    @Override
    public Keyboard readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Keyboard> readAll() {
        Iterable<Keyboard> result = repository.findAll();
        return result;
    }

    @Override
    public Keyboard update(Keyboard entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Keyboard entity) {
        repository.delete(entity);
    }
}
