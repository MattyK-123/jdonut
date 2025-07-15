package com.mpk.matrix;

public final class Vec3 extends Matrix {

    public Vec3() {
        super(3, 1);
        values[0] = 0;
        values[1] = 0;
        values[2] = 0;
    }

    public Vec3(int x, int y, int z) {
        super(3, 1);
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

}
