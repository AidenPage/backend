package com.computerstore.backend.factories.components;

import com.computerstore.backend.domain.components.DisplayCard;

/**
 * Created by Aiden on 2016/10/23.
 */
public class DisplayCardFactory {

    public static DisplayCard getDisplayCardFactory(String Name, String Description, String Stock, String Price)
    {
        DisplayCard displayCard = new DisplayCard.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return displayCard;
    }
}
