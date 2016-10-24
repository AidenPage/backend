package com.computerstore.backend.factories.peripherals;

import com.computerstore.backend.domain.peripherals.Speaker;

/**
 * Created by Aiden on 2016/10/23.
 */
public class SpeakerFactory {

    public static Speaker getSpeaker(String Name, String Description, String Stock, String Price)
    {
        Speaker speaker = new Speaker.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return speaker;
    }
}
