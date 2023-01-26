package ds_primer;

public class MatrixReshape_566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        if (r * c != row * col)
            return mat;
        int[][] res = new int[r][c];
        int rPtr = 0, cPtr = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res[rPtr][cPtr++] = mat[i][j];
                if (cPtr >= c) {
                    cPtr = 0;
                    ++rPtr;
                }
            }
        }
        return res;
    }

    public int[][] matrixReshape_2(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        if (r * c != row * col)
            return mat;

        int[][] res = new int[r][c];
        for (int i = 0; i < row * col; ++i)
            res[i / c][i % c] = mat[i / col][i % col];
        return res;
    }

    public static void main(String[] args) {
        MatrixReshape_566 test = new MatrixReshape_566();
        int a[][] = {{1, 2}, {3, 4}};
        test.matrixReshape(a, 4, 1);
    }
}
