package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.Processor;

/**
 * Created by Aiden on 2016/10/23.
 */
public class ProcessorFactory {

    public static Processor getProcessor(String Name, String Description, String Stock, String Price)
    {
        Processor processor = new Processor.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return processor;
    }
}
