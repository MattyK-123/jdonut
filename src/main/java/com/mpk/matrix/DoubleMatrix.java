package com.mpk.matrix;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public class DoubleMatrix {

    int rows;
    int cols;

    double[] values;

    public DoubleMatrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }

        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows * cols];
    }

    public DoubleMatrix(double[][] values) {
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

    public DoubleMatrix matmul(DoubleMatrix other) {
        if (other.rows != this.cols) {
            throw new IllegalArgumentException("For matrix multiplication, the number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        DoubleMatrix result = new DoubleMatrix(this.rows, other.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.get(i, k) * other.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }

    public DoubleMatrix add(DoubleMatrix other) {
        return elementWiseOperation(other, (x, y) -> x + y);
    }

    public DoubleMatrix subtract(DoubleMatrix other) {
        return elementWiseOperation(other, (x, y) -> x - y);
    }

    public DoubleMatrix multiply(DoubleMatrix other) {
        return elementWiseOperation(other, (x, y) -> x * y);
    }

    public DoubleMatrix divide(DoubleMatrix other) {
        return elementWiseOperation(other, (x, y) -> x / y);
    }

    private DoubleMatrix elementWiseOperation(DoubleMatrix other, DoubleBinaryOperator operation) {
        if (other.rows != this.rows || other.cols != this.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        DoubleMatrix result = new DoubleMatrix(rows, cols);

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

    public static DoubleMatrix add(DoubleMatrix a, DoubleMatrix b) {
        return a.add(b);
    }

    public static DoubleMatrix subtract(DoubleMatrix a, DoubleMatrix b) {
        return a.subtract(b);
    }

    public static DoubleMatrix multiply(DoubleMatrix a, DoubleMatrix b) {
        return a.multiply(b);
    }

    public static DoubleMatrix divide(DoubleMatrix a, DoubleMatrix b) {
        return a.divide(b);
    }

    public static DoubleMatrix matmul(DoubleMatrix a, DoubleMatrix b) {
        return a.matmul(b);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DoubleMatrix that)) return false;
        return rows == that.rows && cols == that.cols && Objects.deepEquals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, Arrays.hashCode(values));
    }

}
