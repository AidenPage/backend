package com.computerstore.backend.services.peripherals.Impl;

import com.computerstore.backend.domain.peripherals.Printer;
import com.computerstore.backend.domain.peripherals.Printer;
import com.computerstore.backend.repositories.peripherals.PrinterRepository;
import com.computerstore.backend.services.peripherals.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    private PrinterRepository repository;

    @Override
    public Printer create(Printer entity) {
        return repository.save(entity);
    }

    @Override
    public Printer readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Printer> readAll() {
        Iterable<Printer> result = repository.findAll();
        return result;
    }

    @Override
    public Printer update(Printer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Printer entity) {
        repository.delete(entity);
    }
}
