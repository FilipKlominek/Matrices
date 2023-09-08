package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeterminantTest {
    @Test
    public void should_Return_NaN_When_Not_Square() {
        double[][][] matrices = {
                {
                        {1, 3, 4},
                        {0, -9, 0.6}
                },
                {
                        {1},
                        {2}
                }
        };
        for (double[][] matrix : matrices) {
            Assertions.assertTrue(Double.isNaN(new Matrix(matrix).determinant()));
        }
    }

    @Test
    public void should_Return_Determinant() {
        double[][][] matrices = {
                {
                        {3, 0, -2},
                        {0, 5, -0.5},
                        {1, 1.5, -1}
                },
                {
                        {1.25, 3},
                        {-9, -9}
                },
                {
                        {9}
                }
        };
        double[] determinants = {7.25, 15.75, 9};
        for (int i = 0; i < matrices.length; i++) {
            Assertions.assertEquals(new Matrix(matrices[i]).determinant(), determinants[i]);
        }
    }
}
