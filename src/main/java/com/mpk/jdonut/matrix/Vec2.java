package com.mpk.jdonut.matrix;

public final class Vec2 extends Matrix {

    public Vec2() {
        super(2, 1);
        values[0] = 0;
        values[1] = 0;
    }

    public Vec2(double x, double y) {
        super(2, 1);
        values[0] = x;
        values[1] = y;
    }

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

}
