public class FindDiagonalOrder_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[]{};

        int row = mat.length, col = mat[0].length;
        int[] res = new int[row * col];
        int x = 0, y = 0, index = 0;

        // i: The number of diagonal line
        for (int i = 0; i < row + col - 1; ++i) {
            // Direction: right top
            if (i % 2 == 0) {
                while (y >= 0 && x < col) {
                    res[index++] = mat[y][x];
                    --y;
                    ++x;
                }
                // At boundary
                if (x < col)
                    ++y;
                else {
                    y += 2;
                    --x;
                }
            } else {
                while (y < row && x >= 0) {
                    res[index++] = mat[y][x];
                    ++y;
                    --x;
                }
                // At boundary
                if (y < row)
                    ++x;
                else {
                    --y;
                    x += 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindDiagonalOrder_498 findDiagonal = new FindDiagonalOrder_498();
        int test[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int res[] = findDiagonal.findDiagonalOrder(test);
    }
}
