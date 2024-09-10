package round2.hot100.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes_73 {
    /*
        1. 第一次先遍历数组，用两个 set 记录下哪些行和那些列有 0
        2. 第二次遍历数组，将 行 或者 列 标记有 0 的都设为 0
    */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 将当前行和列记录为有 0
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        // 第二次遍历
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;

    }
}
