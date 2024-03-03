package round1.hash;

import java.util.HashSet;
import java.util.Set;

public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 是否存在问题且元素个数多 -> 集合 -> 不需要 k-v, set 确保唯一性
        // 一个 set 存第一个数组出现过的元素，一个 set 记录结果
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // 遍历第一个数组记录元素，由于 set 保证唯一性，直接 add元素
        for (int j : nums1)
            set.add(j);
        // 遍历第二个数组，检查哪些元素重复出现
        for (int j : nums2)
            if (set.contains(j))
                resSet.add(j);

        int[] resArr = new int[resSet.size()];
        int index = 0;
        // 遍历 resSet 将元素存到数组
        for (int i : resSet)
            resArr[index++] = i;

        return resArr;
    }
}
