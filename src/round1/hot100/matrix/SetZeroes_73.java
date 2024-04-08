package round1.hot100.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes_73 {
    public void setZeroes(int[][] matrix) {
        // 用两个 HashSet 记录哪些行和列有 0
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        // 扫两遍 matrix，第一遍用于记录哪些行和列有 0
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // 第二遍设置 0
        for (int i = 0; i < rowLen; i++)
            for (int j = 0; j < colLen; j++)
                if (rowSet.contains(i) || colSet.contains(j))
                    matrix[i][j] = 0;

    }
}
