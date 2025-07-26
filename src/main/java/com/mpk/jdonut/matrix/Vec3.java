package com.mpk.jdonut.matrix;

public final class Vec3 extends Matrix {

    public Vec3() {
        super(3, 1);
        values[0] = 0;
        values[1] = 0;
        values[2] = 0;
    }

    public Vec3(double x, double y, double z) {
        super(3, 1);
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

    public double getZ() {
        return values[2];
    }

}
