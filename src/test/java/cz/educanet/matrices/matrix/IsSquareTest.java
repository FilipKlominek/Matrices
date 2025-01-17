package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsSquareTest {
    @Test
    public void should_Return_False_When_NotSquare() {
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
            Assertions.assertFalse(new Matrix(matrix).isSquare());
        }
    }
    @Test
    public void should_Return_True_When_Square() {
        double[][][] matrices = {
                {
                        {3, 0, 0, -0.89},
                        {0, 0, 5, -0.89},
                        {1, 0, 98.2, 123},
                        {1, 0, 98.2, 123}
                },
                {
                        {3, 0, -0.89},
                        {0, 5, -0.89},
                        {1, 98.2, 123}
                },
                {
                        {1.36, 3},
                        {-9, -9}
                },
                {
                        {9}
                }
        };
        for (double[][] matrix : matrices) {
            Assertions.assertTrue(new Matrix(matrix).isSquare());
        }
    }

}
