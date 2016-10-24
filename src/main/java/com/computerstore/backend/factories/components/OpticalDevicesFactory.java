package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.OpticalDevices;

/**
 * Created by Aiden on 2016/10/23.
 */
public class OpticalDevicesFactory {

    public static OpticalDevices getOpticalDevices(String Name, String Description, String Stock, String Price)
    {
        OpticalDevices opticalDevices = new OpticalDevices.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return opticalDevices;
    }
}
