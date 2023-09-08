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
        double[][][] transposedMatrices = {
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
            Assertions.assertEquals(new Matrix(matrices[i]).transpose(), new Matrix(transposedMatrices[i]));
        }

    }
}
