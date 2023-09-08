package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetTraceTest {

    @Test
    public void should_Return_Null_When_NotSquare() {
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
        for (double[][] doubles : matrices) {
            Assertions.assertNull(new Matrix(doubles).getTrace());
        }
    }

    @Test
    public void should_Not_Return_Null_When_Square() {
        double[][][] matrices = {
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
        for (double[][] doubles : matrices) {
            Assertions.assertNotNull(new Matrix(doubles).getTrace());
        }
    }

    @Test
    public void should_Return_CorrectTrace() {
        double[][][] matrices = {
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
        double[] results = {131, -8.36, 9};

        for (int i = 0; i < matrices.length; i++) {
            Matrix matrix = new Matrix(matrices[i]);
            Assertions.assertEquals(matrix.getTrace(), results[i]);
        }
    }
}
