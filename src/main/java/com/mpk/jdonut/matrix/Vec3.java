package com.mpk.jdonut.matrix;

import lombok.ToString;

import java.util.function.DoubleBinaryOperator;

@ToString(callSuper = true)
public final class Vec3 extends Matrix {

    public static Vec3 of(double x, double y, double z) {
        return new Vec3(x, y, z);
    }

    Vec3() {
        super(3, 1);
    }

    private Vec3(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public Vec3 add(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x + y);
    }

    @Override
    public Vec3 subtract(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x - y);
    }

    @Override
    public Vec3 multiply(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x * y);
    }

    @Override
    public Vec3 divide(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x / y);
    }

    @Override
    public Vec3 elementWiseOperation(Matrix other, DoubleBinaryOperator operation) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        return new Vec3(
                operation.applyAsDouble(values[0], other.values[0]),
                operation.applyAsDouble(values[1], other.values[1]),
                operation.applyAsDouble(values[2], other.values[2])
        );
    }


}