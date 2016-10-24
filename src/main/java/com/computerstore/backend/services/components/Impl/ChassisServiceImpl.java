package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.Chassis;
import com.computerstore.backend.repositories.components.ChassisRepository;
import com.computerstore.backend.services.components.ChassisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class ChassisServiceImpl implements ChassisService {

    @Autowired
    private ChassisRepository repository;

    @Override
    public Chassis create(Chassis entity) {
        return repository.save(entity);
    }

    @Override
    public  Chassis readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< Chassis> readAll() {
        Iterable< Chassis> result = repository.findAll();
        return result;
    }

    @Override
    public  Chassis update( Chassis entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( Chassis entity) {
        repository.delete(entity);
    }
}
