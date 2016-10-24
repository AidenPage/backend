package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.Memory;

/**
 * Created by Aiden on 2016/10/23.
 */
public class MemoryFactory {

    public static Memory getMemory(String Name, String Description, String Stock, String Price)
    {
        Memory memory = new Memory.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return memory;
    }
}
