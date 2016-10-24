package com.computerstore.backend.factories.peripherals;

import com.computerstore.backend.domain.peripherals.Keyboard;

/**
 * Created by Aiden on 2016/10/23.
 */
public class KeyboardFactory {

    public static Keyboard getKeyboard(String Name, String Description, String Stock, String Price)
    {
        Keyboard keyboard = new Keyboard.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return keyboard;
    }
}
