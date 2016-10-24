package com.computerstore.backend.factories.peripherals;

import com.computerstore.backend.domain.peripherals.Printer;

/**
 * Created by Aiden on 2016/10/23.
 */
public class PrinterFactory {

    public static Printer getPrinter(String Name, String Description, String Stock, String Price)
    {
        Printer printer = new Printer.Builder()
                .name(Name)
                .stock(Description)
                .price(Stock)
                .description(Price)
                .build();
        return printer;
    }
}
