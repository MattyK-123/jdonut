package com.mpk.jdonut.matrix;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.function.DoubleBinaryOperator;

@ToString
@EqualsAndHashCode
public sealed class Matrix permits Vec2, Vec3 {

    @Getter
    protected final int rows;
    @Getter
    protected final int cols;

    protected final double[] values;

    public double get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid row or column index.");
        }

        return values[row * cols + col];
    }

    public static Matrix of(double[][] values) {
        return new Matrix(values);
    }

    public static Matrix identity(int size) {
        Matrix result = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            result.values[i * size + i] = 1.0;
        }
        return result;
    }

    public Matrix add(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x + y);
    }

    public Matrix subtract(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x - y);
    }

    public Matrix multiply(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x * y);
    }

    public Matrix divide(Matrix other) {
        return elementWiseOperation(other, (x, y) -> x / y);
    }

    public Matrix elementWiseOperation(Matrix other, DoubleBinaryOperator operation) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < values.length; i++) {
            result.values[i] = operation.applyAsDouble(values[i], other.values[i]);
        }

        return result;
    }

    public Matrix matMul(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("For matrix multiplication, the number of columns in the first matrix must equal the number of rows in the second matrix.");
        }

        if (rows == 2 && other.cols == 1) {
            double x = 0;
            double y = 0;
            for (int k = 0; k < cols; k++) {
                x += values[k] * other.values[k];
                y += values[cols + k] * other.values[k];
            }
            return Vec2.of(x, y);
        }

        if (rows == 3 && other.cols == 1) {
            double x = 0;
            double y = 0;
            double z = 0;
            for (int k = 0; k < cols; k++) {
                x += values[k] * other.values[k];
                y += values[cols + k] * other.values[k];
                z += values[2 * cols + k] * other.values[k];
            }
            return Vec3.of(x, y, z);
        }

        Matrix result = new Matrix(rows, other.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += values[i * cols + k] * other.values[k * other.cols + j];
                }
                result.values[i * result.cols + j] = sum;
            }
        }

        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.values[j * rows + i] = values[i * cols + j];
            }
        }

        return result;
    }

    public double[][] toArray() {
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(values, i * cols, result[i], 0, cols);
        }

        return result;
    }

    private Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }

        this.rows = rows;
        this.cols = cols;
        values = new double[rows * cols];
    }

    private Matrix(double[][] values) {
        this(values.length, values[0].length);

        if (values[0].length == 0) {
            throw new IllegalArgumentException("Matrix must have non-zero dimensions.");
        }

        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }

            System.arraycopy(values[i], 0, this.values, i * cols, cols);
        }
    }

    protected Matrix(double x, double y) {
        rows = 2;
        cols = 1;
        values = new double[]{x, y};
    }

    protected Matrix(double x, double y, double z) {
        rows = 3;
        cols = 1;
        values = new double[]{x, y, z};
    }

}