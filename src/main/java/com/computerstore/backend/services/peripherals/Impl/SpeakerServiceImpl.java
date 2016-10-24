package com.computerstore.backend.services.peripherals.Impl;

import com.computerstore.backend.domain.peripherals.Speaker;
import com.computerstore.backend.repositories.peripherals.SpeakerRepository;
import com.computerstore.backend.services.peripherals.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository repository;

    @Override
    public Speaker create(Speaker entity) {
        return repository.save(entity);
    }

    @Override
    public Speaker readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Speaker> readAll() {
        Iterable<Speaker> result = repository.findAll();
        return result;
    }

    @Override
    public Speaker update(Speaker entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Speaker entity) {
        repository.delete(entity);
    }
}
