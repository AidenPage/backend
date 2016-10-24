package com.computerstore.backend.services.peripherals.Impl;

import com.computerstore.backend.domain.peripherals.Monitor;
import com.computerstore.backend.repositories.peripherals.MonitorRepository;
import com.computerstore.backend.services.peripherals.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository repository;

    @Override
    public Monitor create(Monitor entity) {
        return repository.save(entity);
    }

    @Override
    public Monitor readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Monitor> readAll() {
        Iterable<Monitor> result = repository.findAll();
        return result;
    }

    @Override
    public Monitor update(Monitor entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Monitor entity) {
        repository.delete(entity);
    }
}
