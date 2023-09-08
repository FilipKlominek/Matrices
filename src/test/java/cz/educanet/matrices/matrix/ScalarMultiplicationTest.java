package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScalarMultiplicationTest {
    @Test
    public void should_Return_MultipliedMatrix() {
        double[][][] matrices = {
                {
                        {1, 3, 4},
                        {0, -9, 0.6}
                },
                {
                        {1.25, 3},
                        {-9, -9}
                },
                {
                        {1},
                        {2}
                },
                {
                        {9}
                }
        };
        double[] multipliers = {2, 4, 0, -0.5};
        double[][][] results = {
                {
                        {2, 6, 8},
                        {0, -18, 1.2}
                },
                {
                        {5, 12},
                        {-36, -36}
                },
                {
                        {0},
                        {0}
                },
                {
                        {-4.5}
                }
        };

        for (int i = 0; i < matrices.length; i++) {
            Matrix multipliedMatrix = (Matrix) new Matrix(matrices[i]).times(multipliers[i]);
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(multipliedMatrix.get(j, k), results[i][j][k]);
                }
            }
        }
    }
}
