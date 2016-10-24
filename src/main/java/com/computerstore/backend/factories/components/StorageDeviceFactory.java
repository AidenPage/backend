package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.StorageDevice;

/**
 * Created by Aiden on 2016/10/23.
 */
public class StorageDeviceFactory {

    public static StorageDevice getStorageDevice(String Name, String Description, String Stock, String Price)
    {
        StorageDevice storageDevice = new StorageDevice.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return storageDevice;
    }
}
