package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.PowerSupply;

/**
 * Created by Aiden on 2016/10/23.
 */
public class PowerSupplyFactory {

    public static PowerSupply getPowerSupply(String Name, String Description, String Stock, String Price)
    {
        PowerSupply powerSupply = new PowerSupply.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return powerSupply;
    }
}
