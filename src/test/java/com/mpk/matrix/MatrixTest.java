package com.mpk.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testAdd() {
        Matrix matrix1 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        Matrix matrix2 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        Matrix expected = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        Matrix actual = Matrix.add(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testSubtract() {
        Matrix matrix1 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        Matrix matrix2 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        Matrix expected = new Matrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        Matrix actual = Matrix.subtract(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMultiply() {
        Matrix matrix1 = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        Matrix matrix2 = new Matrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        Matrix expected = new Matrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        Matrix actual = Matrix.multiply(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {
        Matrix matrix1 = new Matrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        Matrix matrix2 = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        Matrix expected = new Matrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        Matrix actual = Matrix.divide(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMatmul() {
        Matrix matrix1 = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        Matrix matrix2 = new Matrix(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        Matrix expected = new Matrix(new double[][]{
                {58, 64},
                {139, 154},
        });

        Matrix actual = Matrix.matmul(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testTranspose() {
        Matrix matrix = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        Matrix expected = new Matrix(new double[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        });

        Matrix actual = matrix.transpose();

        assertEquals(expected, actual);
    }

}