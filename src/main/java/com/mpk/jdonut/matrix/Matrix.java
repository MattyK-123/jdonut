package com.mpk.jdonut.matrix;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.function.DoubleBinaryOperator;

@ToString
@EqualsAndHashCode
public class Matrix {

    @Getter
    private final int rows;
    @Getter
    private final int cols;

    private final double[] values;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }

        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows * cols];
    }

    public Matrix(double[][] values) {
        this(values.length, values[0].length);

        if (values[0].length == 0) {
            throw new IllegalArgumentException("Matrix must have non-zero dimensions.");
        }

        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }

            for (int j = 0; j < cols; j++) {
                this.values[i * cols + j] = values[i][j];
            }
        }
    }

    private Matrix(double x, double y) {
        this(2, 1);
        this.values[0] = x;
        this.values[1] = y;
    }

    private Matrix(double x, double y, double z) {
        this(3, 1);
        this.values[0] = x;
        this.values[1] = y;
        this.values[2] = z;
    }

    public static Matrix vec2(double x, double y) {
        return new Matrix(x, y);
    }

    public static Matrix vec3(double x, double y, double z) {
        return new Matrix(x, y, z);
    }

    public double get(int row, int col) {
        return values[row * cols + col];
    }

    public Matrix matmul(Matrix other) {
        if (other.rows != this.cols) {
            throw new IllegalArgumentException("For matrix multiplication, the number of columns in the first matrix must equal the number of rows in the second matrix.");
        }

        Matrix result = new Matrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.values[i * this.cols + k] * other.values[k * other.cols + j];
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

    public static Matrix add(Matrix a, Matrix b) {
        return a.add(b);
    }

    public static Matrix subtract(Matrix a, Matrix b) {
        return a.subtract(b);
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        return a.multiply(b);
    }

    public static Matrix divide(Matrix a, Matrix b) {
        return a.divide(b);
    }

    public static Matrix matmul(Matrix a, Matrix b) {
        return a.matmul(b);
    }

    private Matrix elementWiseOperation(Matrix other, DoubleBinaryOperator operation) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < values.length; i++) {
            result.values[i] = operation.applyAsDouble(this.values[i], other.values[i]);
        }

        return result;
    }

}