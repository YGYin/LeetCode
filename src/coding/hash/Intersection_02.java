package coding.hash;

import java.util.HashSet;
import java.util.Set;

public class Intersection_02 {
    /*
        基本思路：因为查元素是否存在，用哈希法；
                 又因为没有限定数据范围且不是 k-v，结果还需要去重，用 set
                 将原来的 nums1 数组直接转换为 set1，用 nums2 中的的元素和 set1 比较
                 将重复的元素存到 resSet 当中
                 最后再将 resSet 转化为数组

        时间复杂度: O(n)
        空间复杂度: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        // 将数组 nums1 转换为 set1
        for (int i = 0; i < nums1.length; i++)
            set1.add(nums1[i]);
        // 遍历数组 nums 2，并同时判断看 set1 中是否存在该元素，存在就放进 resSet 中
        for (int i = 0; i < nums2.length; i++)
            if (set1.contains(nums2[i]))
                resSet.add(nums2[i]);

        // 申请一个数组存放 resSet 的元素
        int[] resArr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet)
            resArr[j++] = i;

        return resArr;
    }

    // 2. 数组
    public int[] intersection_2(int[] nums1, int[] nums2) {
        int[] hash = new int[1005];
        Set<Integer> resSet = new HashSet<>();

        // 让 hash 表中对应下标位置的值为 1
        for (int i = 0; i < nums1.length; i++)
            hash[nums1[i]] = 1;
        // 遍历数组 nums 2，并同时判断看 set1 中是否存在该元素，存在就放进 resSet 中
        for (int i = 0; i < nums2.length; i++)
            if (hash[nums2[i]] == 1)
                resSet.add(nums2[i]);

        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet)
            arr[j++] = i;

        return arr;
    }
}
