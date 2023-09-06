package cz.educanet.matrices.matrixFactory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * See possible naming <a href="https://medium.com/@stefanovskyi/unit-test-naming-conventions-dd9208eadbea"></a>conventions</a>
 */
class CreateMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_SizeIsValid() {
        int[] validSizes = {2, 4, 6, 10};

        for (int size : validSizes) {
            IMatrix matrix = matrixFactory.createZero(size);

            Assertions.assertEquals(size, matrix.getRows());
            Assertions.assertEquals(size, matrix.getColumns());
        }
    }

    @Test
    public void should_ThrowException_When_NegativeSize() {
        int[] negativeSizes = {-2, -10, -Integer.SIZE};

        for (int size : negativeSizes)
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createZero(size));
    }

    @Test
    public void rawArray_Should_Equal_Input() {
        double[][][] matrices = {
                {
                        {1, 2, 3},
                        {1, -5, 7},
                        {-1, -5, -8}
                },
                {
                        {0.9, -8.982},
                        {9.96, 46},
                        {-8, -101.3},
                        {7, -101.3}
                }
        };


        for (int i = 0; i < matrices.length; i++) {
            Matrix matrix = (Matrix) MatrixFactory.instance.create(matrices[i]);
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(matrices[i][j][k], matrix.get(j, k));
                }
            }
        }
    }
}