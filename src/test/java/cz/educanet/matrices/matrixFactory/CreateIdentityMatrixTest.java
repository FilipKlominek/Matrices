package cz.educanet.matrices.matrixFactory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateIdentityMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_SizeIsValid() {
        int[] validSizes = {2, 4, 6, 10};

        for (int size : validSizes) {
            IMatrix matrix = matrixFactory.createIdentity(size);

            Assertions.assertEquals(size, matrix.getRows());
            Assertions.assertEquals(size, matrix.getColumns());
        }
    }

    @Test
    public void should_ThrowException_When_NegativeSize() {
        int[] negativeSizes = {-2, -10, -Integer.SIZE};

        for (int size : negativeSizes)
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size));
    }

    @Test
    public void should_Create_IdentityMatrix() {
        int[] lengths = {1, 2, 3, 4};
        double[][][] matrices = {
                {
                        {1}
                },
                {
                        {1, 0},
                        {0, 1},
                },
                {
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}
                },
                {
                        {1, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1}
                }
        };
        for (int i = 0; i < lengths.length; i++) {
            Matrix identity = (Matrix) MatrixFactory.instance.createIdentity(lengths[i]);
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(matrices[i][j][k], identity.get(j, k));
                }
            }
        }
    }
}
