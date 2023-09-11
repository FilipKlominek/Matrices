package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransposeTest {
    @Test
    public void should_Return_TransposedMatrix() {
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
        double[][][] results = {
                {
                        {1, 0},
                        {3, -9},
                        {4, 0.6}
                },
                {
                        {1.25, -9},
                        {3, -9}
                },
                {
                        {1, 2}
                },
                {
                        {9}
                }
        };
        for (int i = 0; i < matrices.length; i++) {
            Matrix transposedMatrix = (Matrix) new Matrix(matrices[i]).transpose();
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(transposedMatrix.get(k, j), results[i][k][j]);
                    //what
                }
            }
        }
    }
}
