package com.mpk.matrix;

public final class Vec2 extends Matrix {

    public Vec2() {
        super(2, 1);
        values[0] = 0;
        values[1] = 0;
    }

    public Vec2(int x, int y) {
        super(2, 1);
        values[0] = x;
        values[1] = y;
    }

}
