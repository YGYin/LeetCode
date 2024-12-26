package round3.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    /*
        螺旋矩阵
        为 m * n，不为正方形，
        分别定义上下左右四个边界，每次移动到当前方向的最后一格，
        变换方向前先移动一格看是否有越界，有则 break，正常则直接再移动到当前方向的最后一格子
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 判空
        if (matrix.length < 1 || matrix[0].length < 1)
            return res;
        // 定义四个边界
        int upBound = 0, leftBound = 0;
        int downBound = matrix.length - 1, rightBound = matrix[0].length - 1;

        while (true) {
            // 第一行从左到右
            for (int i = leftBound; i <= rightBound; i++)
                res.add(matrix[upBound][i]);
            // 第一行遍历完，收缩上边界，如果越界则 break
            if (++upBound > downBound)
                break;

            // 最右边从上到下
            for (int i = upBound; i <= downBound; i++)
                res.add(matrix[i][rightBound]);
            // 尝试收缩右边界
            if (--rightBound < leftBound)
                break;

            // 最下边从右到左
            for (int i = rightBound; i >= leftBound; i--)
                res.add(matrix[downBound][i]);
            // 尝试收缩下边界
            if (--downBound < upBound)
                break;

            // 最左边从下到上
            for (int i = downBound; i >= upBound; i--)
                res.add(matrix[i][leftBound]);
            // 尝试收缩左边界
            if (++leftBound > rightBound)
                break;
        }

        return res;
    }
}
