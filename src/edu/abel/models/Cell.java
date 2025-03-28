package edu.abel.models;

public class Cell {
    private int value;
    private final boolean isFixed; // Define se é uma célula pré-definida

    public Cell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!this.isFixed()) {
            this.value = value;
        }
    }

    public boolean isFixed() {
        return isFixed;
    }
}
