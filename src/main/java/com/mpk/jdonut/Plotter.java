package com.mpk.jdonut;

import java.util.Arrays;

public class Plotter {

    private final int cols;
    private final int rows;

    private final char[] values;

    Plotter(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        values = new char[this.rows * this.cols];
    }

    @SuppressWarnings("java:S106")
    private void clear() {
        for (int row = 0; row < rows; row++) {
            int rowStart = row * cols;
            Arrays.fill(values, rowStart, rowStart + cols - 1, ' ');
            values[rowStart + cols - 1] = '\n';
        }
    }

}
