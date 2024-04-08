package round1.hot100.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> res = new LinkedList<>();
        // 此处按题设可不判空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        // 定义上下左右四个边界
        int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (true) {
            // 从左上角开始
            // 先从左到右
            for (int i = left; i <= right; i++)
                res.add(matrix[up][i]);

            // 准备从上到下，先移动一格并判断边界
            if (++up > down)
                break;
            for (int i = up; i <= down; i++)
                res.add(matrix[i][right]);

            // 准备从左到右
            if (--right < left)
                break;
            for (int i = right; i >= left; i--)
                res.add(matrix[down][i]);

            // 准备从下晚上，上一格
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            // 为下次从左到右边做准备
            if (++left > right)
                break;
        }
        return res;
    }

}
