package com.mpk.jdonut.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testAdd() {
        var matrix1 = Matrix.of(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var matrix2 = Matrix.of(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var expected = Matrix.of(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var actual = matrix1.add(matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testSubtract() {
        var matrix1 = Matrix.of(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var matrix2 = Matrix.of(new double[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        });

        var expected = Matrix.of(new double[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });

        var actual = matrix1.subtract(matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMultiply() {
        var matrix1 = Matrix.of(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var matrix2 = Matrix.of(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        var expected = Matrix.of(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        var actual = matrix1.multiply(matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {
        var matrix1 = Matrix.of(new double[][]{
                {6, 6, 6},
                {6, 6, 6},
                {6, 6, 6}
        });

        var matrix2 = Matrix.of(new double[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        });

        var expected = Matrix.of(new double[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });

        var actual = matrix1.divide(matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testMatmul() {
        var matrix1 = Matrix.of(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        var matrix2 = Matrix.of(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        var expected = Matrix.of(new double[][]{
                {58, 64},
                {139, 154},
        });

        var actual = matrix1.matMul(matrix2);

        assertEquals(expected, actual);
    }

    @Test
    void testTranspose() {
        var matrix = Matrix.of(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        var expected = Matrix.of(new double[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        });

        var actual = matrix.transpose();

        assertEquals(expected, actual);
    }

}