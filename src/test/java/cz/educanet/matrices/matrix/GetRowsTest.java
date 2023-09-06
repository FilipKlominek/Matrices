package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetRowsTest {

    @Test
    public void should_GetNumberOfRows() {
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

        for (double[][] doubles : matrices) {
            Matrix matrix = (Matrix) MatrixFactory.instance.create(doubles);
            Assertions.assertEquals(matrix.getRows(), doubles.length);
        }
    }
}
