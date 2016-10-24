package com.computerstore.backend.factories.peripherals;

import com.computerstore.backend.domain.peripherals.Monitor;

/**
 * Created by Aiden on 2016/10/23.
 */
public class MonitorFactory {

    public static Monitor getMonitor(String Name, String Description, String Stock, String Price)
    {
        Monitor monitor = new Monitor.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return monitor;
    }
}
