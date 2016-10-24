package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.Chassis;

/**
 * Created by Aiden on 2016/10/23.
 */
public class ChassisFactory {

    public static Chassis getChassis(String Name, String Description, String Stock, String Price)
    {
        Chassis chassis = new Chassis.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return chassis;
    }
}
