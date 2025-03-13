package round4.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    /*
        螺旋矩阵
        1. 定义四个边界，每次遍历完了一条边界后尝试收缩当前边界
        2. 需要边界收缩后判断是否越界，越界后直接 break
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 定义四个边界，左闭右闭
        int leftBound = 0, rightBound = matrix[0].length - 1;
        int upBound = 0, downBound = matrix.length - 1;

        while (true) {
            // 上边从左到右
            for (int i = leftBound; i <= rightBound; i++)
                res.add(matrix[upBound][i]);
            // 尝试收缩上边界
            if (++upBound > downBound)
                break;

            // 右边从上到下
            for (int i = upBound; i <= downBound; i++)
                res.add(matrix[i][rightBound]);
            // 尝试收缩右边界
            if (--rightBound < leftBound)
                break;

            // 下边从右到左
            for (int i = rightBound; i >= leftBound; i--)
                res.add(matrix[downBound][i]);
            // 尝试收缩下边界
            if (--downBound < upBound)
                break;

            // 左边从下到上
            for (int i = downBound; i >= upBound; i--)
                res.add(matrix[i][leftBound]);
            // 尝试收缩左边界
            if (++leftBound > rightBound)
                break;
        }
        return res;
    }
}
