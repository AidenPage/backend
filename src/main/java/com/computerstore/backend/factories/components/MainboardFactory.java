package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.Mainboard;

/**
 * Created by Aiden on 2016/10/23.
 */
public class MainboardFactory {

    public static Mainboard getMainboard(String Name, String Description, String Stock, String Price)
    {
        Mainboard mainboard = new Mainboard.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return mainboard;
    }
}
