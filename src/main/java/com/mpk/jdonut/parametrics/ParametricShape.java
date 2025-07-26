package com.mpk.jdonut.parametrics;

import com.mpk.jdonut.matrix.Vec3;

@FunctionalInterface
public interface ParametricShape {
    Vec3[] getPoints();
}
