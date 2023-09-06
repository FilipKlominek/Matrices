package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(IMatrix matrix) {
        return null;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix times(Number scalar) {
        return null;
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix add(IMatrix matrix) {
        return null;
    }

    @Override
    public IMatrix transpose() {
        double[][] transpose = new double[this.getColumns()][this.getRows()];
        for (int i = 0; i < this.rawArray.length; i++) {
            for (int j = 0; j < this.rawArray[i].length; j++) {
                transpose[j][i] = this.rawArray[i][j];
            }
        }
        return MatrixFactory.instance.create(transpose);
    }

    @Override
    public double determinant() {
        if (!this.isSquare()) return Double.NaN;

        double determinant = 0;
        int length = this.getRows();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                determinant += this.rawArray[Math.floorMod(j + i, length)][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                determinant -= this.rawArray[Math.floorMod(j + i, length)][j];
            }
        }

        return determinant;

    }

    @Override
    public boolean isSquare() {
        return this.getRows() == this.getColumns();
    }

    @Override
    public boolean isDiagonal() {
        if (!this.isSquare()) return false;
        for (int i = 0; i < this.rawArray.length; i++) {
            for (int j = 0; j < this.rawArray[i].length; j++) {
                if (i != j && this.rawArray[i][j] != 0) return false;
            }
        }
        return true;
    }

    @Override
    public Number getTrace() {
        if (!isSquare()) return null;
        double trace = 0;
        for (int i = 0; i < this.rawArray.length; i++) {
            trace += this.rawArray[i][i];
        }
        return trace;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0) return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0) throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
