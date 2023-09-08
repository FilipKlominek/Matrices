package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetTest {

    @Test
    public void should_Succeed_When_IndexWithinRange() {
        int[][] gets = {
                {1, 2},
                {0, 0},
                {4, 4}
        };

        Matrix matrix = new Matrix(new double[][]{
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d}
        });

        for (int[] get : gets) {
            Assertions.assertEquals(matrix.get(get[0], get[1]), 0d);
        }
    }

    @Test
    public void should_Fail_When_IndexOutOfRange() {
        int[][] gets = {
                {4, 1},
                {0, -1},
                {54, 789}
        };

        Matrix matrix = new Matrix(new double[][]{
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d},
                {0d, 0d, 0d, 0d}
        });

        for (int[] get : gets) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> matrix.get(get[0], get[1]));
        }
    }

    @Test
    public void should_Get_CorrectDouble() {
        double[][] values = {
                {9d, -5d, 0d},
                {0d, 1.35d, -0.56d}
        };

        Matrix matrix = new Matrix(new double[][]{
                {9d, -5d, 0d},
                {0d, 1.35d, -0.56d}
        });

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                Assertions.assertEquals(values[i][j], matrix.get(i, j));
            }
        }
    }

}
