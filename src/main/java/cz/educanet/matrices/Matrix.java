package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (this.getColumns() != matrix.getRows()) return null;
        double[][] result = new double[this.getRows()][matrix.getColumns()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < this.getColumns(); k++) {
                    result[i][j] += this.get(i, k) * matrix.get(k, j);
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] result = new double[this.getRows()][this.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result[i][j] = this.get(i, j) * scalar.doubleValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if (this.getRows() != matrix.getRows() || this.getColumns() != matrix.getColumns())
            return null; //returns null if dimensions do not match
        double[][] result = new double[this.getRows()][this.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result[i][j] = this.get(i, j) + matrix.get(i, j);
            }
        }
        return new Matrix(result);

    }

    @Override
    public IMatrix transpose() {
        double[][] transpose = new double[this.getColumns()][this.getRows()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                transpose[j][i] = this.rawArray[i][j];
            }
        }
        return MatrixFactory.instance.create(transpose);
    }

    @Override
    public double determinant() {
        if (!this.isSquare()) return Double.NaN;
//TODO: it's completely wrong, this is only for 3×3
        double determinant = 0;
        int length = this.getRows();

        for (int i = 0; i < length; i++) {
            double product = 1;
            for (int j = 0; j < length; j++) {
                int mod = Math.floorMod(j + i, length);
                product *= this.rawArray[mod][j];
                System.out.println();
            }
            determinant += product;
        }

        for (int i = 0; i < length; i++) {
            double product = 1;
            for (int j = length - 1; j >= 0; j--) {
                int reverse = length - (j + 1);
                int mod = Math.floorMod(reverse + i, length);
                product *= this.rawArray[mod][j];
                System.out.println();
            }
            determinant -= product;
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
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (i != j && this.rawArray[i][j] != 0) return false;
            }
        }
        return true;
    }

    @Override
    public Number getTrace() {
        if (!isSquare()) return null;
        double trace = 0;
        for (int i = 0; i < this.getRows(); i++) {
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
