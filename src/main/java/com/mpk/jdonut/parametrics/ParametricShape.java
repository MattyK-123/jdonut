package com.mpk.jdonut.parametrics;

import com.mpk.jdonut.matrix.Matrix;

@FunctionalInterface
public interface ParametricShape {
    Matrix[] getPoints();
}
