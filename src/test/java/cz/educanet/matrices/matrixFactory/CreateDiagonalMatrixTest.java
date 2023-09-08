package cz.educanet.matrices.matrixFactory;

import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDiagonalMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Create_Diagonal_Matrix() {
        double[][] diagonals = {
                {1, 9},
                {-0.39, 6, 5.8},
                {0, 0}
        };
        double[][][] matrices = {
                {
                        {1, 0},
                        {0, 9}
                },
                {
                        {-0.39, 0, 0},
                        {0, 6, 0},
                },
                {
                        {0, 0},
                        {0, 0}
                }
        };
        for (int i = 0; i < diagonals.length; i++) {
            Matrix diagonal = (Matrix) MatrixFactory.instance.createDiagonal(diagonals[i]);
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(matrices[i][j][k], diagonal.get(j, k));
                }
            }
        }
    }
}
