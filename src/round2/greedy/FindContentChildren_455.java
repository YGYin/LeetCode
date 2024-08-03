package round2.greedy;

import java.util.Arrays;

public class FindContentChildren_455 {
    /*
        分发饼干
        尽可能用大尺寸饼干先满足胃口大的，for 控制胃口，内部 index 指针控制饼干，
        胃口是随着遍历以及被满足条件都移动，index 只有满足条件才移动
     */
    public int findContentChildren(int[] g, int[] s) {
        // 被满足的孩子数量
        int count = 0;
        // index 指针指向当前最大饼干
        int index = s.length - 1;
        // 需要在开始遍历前对两个数组都进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // for 一定要用于控制胃口，饼干只有被吃了才移动
        for (int i = g.length - 1; i >= 0; i--) {
            // 如果饼干未被分配完，且能满足胃口，移动 index 并更新 count
            if (index >= 0 && s[index] >= g[i]) {
                --index;
                ++count;
            }
        }
        return count;
    }
}
