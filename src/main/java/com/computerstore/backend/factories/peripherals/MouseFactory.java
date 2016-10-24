package com.computerstore.backend.factories.peripherals;

import com.computerstore.backend.domain.peripherals.Mouse;

/**
 * Created by Aiden on 2016/10/23.
 */
public class MouseFactory {

    public static Mouse getMouse(String Name, String Description, String Stock, String Price)
    {
        Mouse mouse = new Mouse.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return mouse;
    }
}
