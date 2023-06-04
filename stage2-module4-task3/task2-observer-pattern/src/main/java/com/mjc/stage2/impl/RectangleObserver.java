package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        int id = event.getSource().getId();
        double sideA = event.getSource().getSideA();
        double sideB = event.getSource().getSideB();

        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);

        RectangleValues values = new RectangleValues(square, perimeter);
        RectangleWarehouse.getInstance().put(id, values);
    }
}
