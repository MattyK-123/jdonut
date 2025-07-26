package com.mpk.jdonut;

import com.mpk.jdonut.matrix.Vec2;

import java.util.Arrays;

public class Plotter {

    private int width = 80;
    private int height = 24;
    private final char[] grid;
    private final StringBuilder sb;

    private static final String ANSI_CLS = "\u001B[2J";
    private static final String ANSI_HOME = "\u001B[H";

    public Plotter() {
        grid = new char[width * height];
        sb = new StringBuilder(width * height + height + 16);
    }

    public Plotter(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[width * height];
        sb = new StringBuilder(width * height + height + 16);
    }

    public void plot(Vec2[] points) {
        Arrays.fill(grid, ' ');

        for (Vec2 point : points) {
            int x = (int) Math.round(point.getX());
            int y = (int) Math.round(point.getY());

            if (x >= 0 && x < width && y >= 0 && y < height) {
                grid[y * width + x] = 'X';
            }
        }

        sb.setLength(0);
        sb.append(ANSI_CLS).append(ANSI_HOME);

        for (int y = 0; y < height; y++) {
            sb.append(grid, y * width, width);
            if (y < height - 1) sb.append('\n');
        }

        System.out.print(sb);
    }
}