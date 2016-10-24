package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.Mainboard;
import com.computerstore.backend.repositories.components.MainboardRepository;
import com.computerstore.backend.services.components.MainboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class MainboardServiceImpl implements MainboardService {

    @Autowired
    private MainboardRepository repository;

    @Override
    public Mainboard create(Mainboard entity) {
        return repository.save(entity);
    }

    @Override
    public  Mainboard readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< Mainboard> readAll() {
        Iterable< Mainboard> result = repository.findAll();
        return result;
    }

    @Override
    public  Mainboard update( Mainboard entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( Mainboard entity) {
        repository.delete(entity);
    }
}
