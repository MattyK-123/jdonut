package com.mpk.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleMatrixTest {

    @Test
    void testAdd() {
        DoubleMatrix matrix1 = new DoubleMatrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        DoubleMatrix matrix2 = new DoubleMatrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        DoubleMatrix actual = DoubleMatrix.add(matrix1, matrix2);

        DoubleMatrix expected = new DoubleMatrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        assertEquals(expected, actual);
    }

    @Test
    void testSubtract() {
        DoubleMatrix matrix1 = new DoubleMatrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        DoubleMatrix matrix2 = new DoubleMatrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        DoubleMatrix actual = DoubleMatrix.subtract(matrix1, matrix2);

        DoubleMatrix expected = new DoubleMatrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        assertEquals(expected, actual);
    }

    @Test
    void testMultiply() {
        DoubleMatrix matrix1 = new DoubleMatrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        DoubleMatrix matrix2 = new DoubleMatrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        DoubleMatrix actual = DoubleMatrix.multiply(matrix1, matrix2);

        DoubleMatrix expected = new DoubleMatrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {
        DoubleMatrix matrix1 = new DoubleMatrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        DoubleMatrix matrix2 = new DoubleMatrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        DoubleMatrix actual = DoubleMatrix.divide(matrix1, matrix2);

        DoubleMatrix expected = new DoubleMatrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        assertEquals(expected, actual);
    }

    @Test
    void testMatmul() {
        DoubleMatrix matrix1 = new DoubleMatrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        DoubleMatrix matrix2 = new DoubleMatrix(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        DoubleMatrix actual = DoubleMatrix.matmul(matrix1, matrix2);

        DoubleMatrix expected = new DoubleMatrix(new double[][]{
                {58, 64},
                {139, 154},
        });

        assertEquals(expected, actual);
    }

}