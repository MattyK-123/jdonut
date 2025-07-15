package com.mpk.matrix;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public sealed class Matrix permits Vec2, Vec3 {

    int rows;
    int cols;

    protected final double[] values;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }

        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows * cols];
    }

    public Matrix(double[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            throw new IllegalArgumentException("Matrix must have non-zero dimensions.");
        }

        rows = values.length;
        cols = values[0].length;
        this.values = new double[rows * cols];

        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }

            for (int j = 0; j < cols; j++) {
                set(i, j, values[i][j]);
            }
        }
    }

    public double get(int row, int col) {
        checkBounds(row, col);
        return values[row * cols + col];
    }

    public void set(int row, int col, double value) {
        checkBounds(row, col);
        values[row * cols + col] = value;
    }

    public Matrix matmul(Matrix other) {
        if (other.rows != this.cols) {
            throw new IllegalArgumentException("For matrix multiplication, the number of columns in the first matrix must be equal to the number of rows in the second matrix.");
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

    private void checkBounds(int row, int col) {
        if (row < 0 || row >= rows) {
            throw new IndexOutOfBoundsException("Row index out of bounds: " + row);
        }
        if (col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Column index out of bounds: " + col);
        }
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Matrix that)) return false;
        return rows == that.rows && cols == that.cols && Objects.deepEquals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, Arrays.hashCode(values));
    }

}
