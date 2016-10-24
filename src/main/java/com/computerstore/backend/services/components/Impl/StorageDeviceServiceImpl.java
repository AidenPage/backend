package com.computerstore.backend.services.components.Impl;

import com.computerstore.backend.domain.components.StorageDevice;
import com.computerstore.backend.repositories.components.StorageDeviceRepository;
import com.computerstore.backend.services.components.StorageDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aiden on 2016/10/23.
 */
@Service
public class StorageDeviceServiceImpl implements StorageDeviceService {

    @Autowired
    private StorageDeviceRepository repository;

    @Override
    public StorageDevice create(StorageDevice entity) {
        return repository.save(entity);
    }

    @Override
    public  StorageDevice readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable< StorageDevice> readAll() {
        Iterable< StorageDevice> result = repository.findAll();
        return result;
    }

    @Override
    public  StorageDevice update( StorageDevice entity) {
        return repository.save(entity);
    }

    @Override
    public void delete( StorageDevice entity) {
        repository.delete(entity);
    }
}
