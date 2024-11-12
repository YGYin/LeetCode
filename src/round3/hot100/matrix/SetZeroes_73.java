package round3.hot100.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes_73 {
    /*
        1. 第一次先遍历数组，用两个 set 记录下哪些行和那些列有 0
        2. 第二次遍历数组，将 行 或者 列 标记有 0 的都设为 0
    */
    public void setZeroes(int[][] matrix) {
        // 用两个 set 记录哪些行或列有 0
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        // 第二次遍历，如果 rowSet 或者 colSet 为 0 就把当前位置设为 0
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;

    }
}
