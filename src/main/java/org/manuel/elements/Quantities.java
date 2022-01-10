package org.manuel.elements;

import javafx.util.Duration;

public enum Quantities {
    SMALL(10),
    MEDIUM(50),
    LARGE(100);

    private final int quantity;

    Quantities(int qty) {
        this.quantity = qty;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public int getQuantity() {
        return quantity;
    }
}
