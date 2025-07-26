package com.mpk.jdonut.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testAdd() {
        var matrix1 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var matrix2 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var expected = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var actual = Matrix.add(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testSubtract() {
        var matrix1 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var matrix2 = new Matrix(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var expected = new Matrix(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        var actual = Matrix.subtract(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMultiply() {
        var matrix1 = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var matrix2 = new Matrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        var expected = new Matrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        var actual = Matrix.multiply(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {
        var matrix1 = new Matrix(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        var matrix2 = new Matrix(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var expected = new Matrix(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        var actual = Matrix.divide(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMatmul() {
        var matrix1 = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        var matrix2 = new Matrix(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        var expected = new Matrix(new double[][]{
                {58, 64},
                {139, 154},
        });

        var actual = Matrix.matmul(matrix1, matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testTranspose() {
        var matrix = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        var expected = new Matrix(new double[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        });

        var actual = matrix.transpose();

        assertEquals(expected, actual);
    }

}