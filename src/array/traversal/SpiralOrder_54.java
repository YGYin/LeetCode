package array.traversal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int elements = 0, n = matrix.length * matrix[0].length;
        while (elements < n) {
            for (int i = left; i <= right && elements < n; ++i) {
                res.add(matrix[top][i]);
                ++elements;
            }
            ++top;
            for (int i = top; i <= bottom && elements < n; ++i) {
                res.add(matrix[i][right]);
                ++elements;
            }
            --right;
            for (int i = right; i >= left && elements < n; --i) {
                res.add(matrix[bottom][i]);
                ++elements;
            }
            --bottom;
            for (int i = bottom; i >= top && elements < n; --i) {
                res.add(matrix[i][left]);
                ++elements;
            }
            ++left;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralOrder_54 spiralOrder_54 = new SpiralOrder_54();
        spiralOrder_54.spiralOrder(matrix);
    }
}
