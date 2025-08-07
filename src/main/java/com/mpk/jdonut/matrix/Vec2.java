package com.mpk.jdonut.matrix;

import lombok.ToString;

import java.util.function.DoubleBinaryOperator;

@ToString(callSuper = true)
public final class Vec2 extends Matrix {

    public static Vec2 of(double x, double y) {
        return new Vec2(x, y);
    }

    Vec2() {
        super(2, 1);
    }

    private Vec2(double x, double y) {
        super(x, y);
    }

    @Override
    public Vec2 add(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x + y);
    }

    @Override
    public Vec2 subtract(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x - y);
    }

    @Override
    public Vec2 multiply(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x * y);
    }

    @Override
    public Vec2 divide(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x / y);
    }

    @Override
    public Vec2 elementWiseOperation(Matrix other, DoubleBinaryOperator operation) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        return new Vec2(
                operation.applyAsDouble(values[0], other.values[0]),
                operation.applyAsDouble(values[1], other.values[1])
        );
    }

}
