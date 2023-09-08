package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimesTest {
    @Test
    public void should_Return_Null_When_ColumnsOfA_Not_EqualTo_RowsOfB() {
        double[][][] matricesA = {
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
                }
        };
        double[][][] matricesB = {
                {
                        {1, 0},
                        {3, -9},
                        {4, 0.6}
                },
                {
                        {1.25, -9},
                        {3, -9},
                        {-3, 9}
                },
                {
                        {1, 2}
                }
        };
        for (int i = 0; i < matricesA.length; i++) {
            Assertions.assertNotNull(new Matrix(matricesA[i]).times(new Matrix(matricesB[i])));
        }
    }

    @Test
    public void should_Return_MultipleOfMatrixAAndMatrixB() {
        double[][][] matricesA = {
                {
                        {1, 3, 0.5}
                },
                {
                        {0, 2},
                        {3, -1}
                },
                {
                        {1},
                        {-0.5}
                }
        };
        double[][][] matricesB = {
                {
                        {2, 2},
                        {4, -1},
                        {-1, -2}
                },
                {
                        {3, -1},
                        {0, 4}
                },
                {
                        {3, 3}
                }
        };
        double[][][] results = {
                {
                        {13.5, -2}
                },
                {
                        {0, 8},
                        {9, -12}
                },
                {
                        {3, 3},
                        {-1.5, -1.5}
                }
        };
        for (int i = 0; i < matricesA.length; i++) {
            Matrix multipliedMatrix = (Matrix) new Matrix(matricesA[i]).times(new Matrix(matricesB[i]));
            for (int j = 0; j < matricesA[i].length; j++) {
                for (int k = 0; k < matricesA[i][j].length; k++) {
                    Assertions.assertEquals(multipliedMatrix.get(j, k), results[i][j][k]);
                }
            }
        }
    }
}
