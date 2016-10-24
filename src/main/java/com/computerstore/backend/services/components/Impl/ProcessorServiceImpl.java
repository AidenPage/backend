package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.Processor;
import com.computerstore.backend.repositories.components.ProcessorRepository;
import com.computerstore.backend.services.components.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class ProcessorServiceImpl implements ProcessorService {

    @Autowired
    private ProcessorRepository repository;

    @Override
    public Processor create(Processor entity) {
        return repository.save(entity);
    }

    @Override
    public  Processor readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< Processor> readAll() {
        Iterable< Processor> result = repository.findAll();
        return result;
    }

    @Override
    public  Processor update( Processor entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( Processor entity) {
        repository.delete(entity);
    }
}
