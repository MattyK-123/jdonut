package com.mpk.jdonut.parametrics;

import com.mpk.jdonut.matrix.Matrix;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

@ToString
@EqualsAndHashCode
public class Torus implements ParametricShape {

    private final Matrix[] points;

    private final double majorRadius;
    private final double minorRadius;

    private final int uSteps;
    private final int vSteps;

    public Torus(double majorRadius, double minorRadius, int uSteps, int vSteps) {
        if (majorRadius <= 0) {
            throw new IllegalArgumentException("Major radius must be greater than 0.");
        }

        if (minorRadius <= 0) {
            throw new IllegalArgumentException("Minor radius must be greater than 0.");
        }

        if (majorRadius <= minorRadius) {
            throw new IllegalArgumentException("Major radius must be greater than minor radius");
        }

        this.uSteps = uSteps;
        this.vSteps = vSteps;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
        this.points = generatePoints();
    }

    private double x(double u, double v) {
        return (majorRadius + minorRadius * cos(v)) * cos(u);
    }

    private double y(double u, double v) {
        return (majorRadius + minorRadius * cos(v)) * sin(u);
    }

    private double z(double v) {
        return minorRadius * sin(v);
    }

    private Matrix[] generatePoints() {
        Matrix[] pts = new Matrix[uSteps * vSteps];
        int index = 0;

        double du = 2 * Math.PI / (uSteps - 1);
        double dv = 2 * Math.PI / (vSteps - 1);

        for (int i = 0; i < uSteps; i++) {
            for (int j = 0; j < vSteps; j++) {
                double u = i * du;
                double v = j * dv;
                pts[index++] = Matrix.of(
                        x(u, v),
                        y(u, v),
                        z(v)
                );
            }
        }

        return pts;
    }

    @Override
    public Matrix[] getPoints() {
        return points;
    }

}
