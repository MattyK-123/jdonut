package com.mpk.jdonut.matrix.util;

import com.mpk.jdonut.matrix.Matrix;
import lombok.experimental.UtilityClass;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

@UtilityClass
public class Rotation {

    public static Matrix rotateX(double angle) {
        return new Matrix(new double[][]{{1, 0, 0}, {0, cos(angle), -sin(angle)}, {0, sin(angle), cos(angle)},});
    }

    public static Matrix rotateY(double angle) {
        return new Matrix(new double[][]{{cos(angle), 0, sin(angle)}, {0, 1, 0}, {-sin(angle), 0, cos(angle)},});
    }

    public static Matrix rotateZ(double angle) {
        return new Matrix(new double[][]{{cos(angle), -sin(angle), 0}, {sin(angle), cos(angle), 0}, {0, 0, 1}});
    }

}
