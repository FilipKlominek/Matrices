package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTest {
    @Test
    public void should_Return_Null_When_DimensionsDoNotMatch() {
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
        double[][][] addedMatrices = {
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
                        {9},
                        {9}
                }
        };
        for (int i = 0; i < matrices.length; i++) {
            Assertions.assertNull(new Matrix(matrices[i]).add(new Matrix(addedMatrices[i])));
        }
    }

    @Test
    public void should_Return_MatrixSum() {
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
        double[][][] addedMatrices = {
                {
                        {3, 1, 0},
                        {0, 5, 0.89},
                        {-2, 1.8, -123}
                },
                {
                        {1.64, 6},
                        {-1, 8}
                },
                {
                        {1}
                }
        };
        double[][][] results = {
                {
                        {6, 1, -0.89},
                        {0, 10, 0},
                        {-1, 100, 0}
                },
                {
                        {3, 9},
                        {-10, -1}
                },
                {
                        {10}
                }
        };
        for (int i = 0; i < matrices.length; i++) {
            Matrix matrixSum = (Matrix) new Matrix(matrices[i]).add(new Matrix(addedMatrices[i]));
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    Assertions.assertEquals(matrixSum.get(j, k), results[i][j][k]);
                }
            }
        }
    }
}
