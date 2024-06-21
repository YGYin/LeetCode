package round2.hash;

import java.util.HashSet;
import java.util.Set;

public class Intersection_349 {
    /*
        两个数组的交集
        求交集需要去重，用 set
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 两个 set，分别用来储存 nums1 去重后的元素，以及交集
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // 遍历 nums1 记录元素
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);

        // 遍历 nums2，将交集存入 resSet，顺便去重
        for (int i = 0; i < nums2.length; i++)
            if (set.contains(nums2[i]))
                resSet.add(nums2[i]);
        // 将 set 转化为数组
        int[] res = new int[resSet.size()];
        int index = 0;
        for (int i : resSet)
            res[index++] = i;

        return res;
    }
}
