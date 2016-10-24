package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.PowerSupply;
import com.computerstore.backend.repositories.components.PowerSupplyRepository;
import com.computerstore.backend.services.components.PowerSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class PowerSupplyServiceImpl implements PowerSupplyService {

    @Autowired
    private PowerSupplyRepository repository;

    @Override
    public PowerSupply create(PowerSupply entity) {
        return repository.save(entity);
    }

    @Override
    public  PowerSupply readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< PowerSupply> readAll() {
        Iterable< PowerSupply> result = repository.findAll();
        return result;
    }

    @Override
    public  PowerSupply update( PowerSupply entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( PowerSupply entity) {
        repository.delete(entity);
    }
}
