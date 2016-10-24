package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.OpticalDevices;
import com.computerstore.backend.repositories.components.OpticalDevicesRepository;
import com.computerstore.backend.services.components.OpticalDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class OpticalDevicesServiceImpl implements OpticalDevicesService {

    @Autowired
    private OpticalDevicesRepository repository;

    @Override
    public OpticalDevices create(OpticalDevices entity) {
        return repository.save(entity);
    }

    @Override
    public  OpticalDevices readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< OpticalDevices> readAll() {
        Iterable< OpticalDevices> result = repository.findAll();
        return result;
    }

    @Override
    public  OpticalDevices update( OpticalDevices entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( OpticalDevices entity) {
        repository.delete(entity);
    }
}
