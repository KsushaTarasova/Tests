package org.example;

public enum Month {
    DECEMBER(12),
    MARCH(3),
    FEBRUARY(2),
    MAY(5),
    JUNE(6),
    JULY(7);

    private int number;
    Month(int i){
        this.number = i;
    }

    public int getNumber() {
        return number;
    }
}
