package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.DisplayCard;
import com.computerstore.backend.repositories.components.DisplayCardRepository;
import com.computerstore.backend.services.components.DisplayCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class DisplayCardServiceImpl implements DisplayCardService {

    @Autowired
    private DisplayCardRepository repository;

    @Override
    public DisplayCard create(DisplayCard entity) {
        return repository.save(entity);
    }

    @Override
    public  DisplayCard readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< DisplayCard> readAll() {
        Iterable< DisplayCard> result = repository.findAll();
        return result;
    }

    @Override
    public  DisplayCard update( DisplayCard entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( DisplayCard entity) {
        repository.delete(entity);
    }
}
