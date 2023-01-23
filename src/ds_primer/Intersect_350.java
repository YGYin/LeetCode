package ds_primer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect_350 {
    // List
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list_1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i)
            list_1.add(nums1[i]);

        ArrayList<Integer> list_2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (list_1.contains(nums2[i])) {
                list_2.add(nums2[i]);
                // 若直接传 nums[2],则代表删除 list 中该下标的元素
                list_1.remove(Integer.valueOf(nums2[i]));
            }
        }
        int[] res = new int[list_2.size()];
        int index = 0;
        for (int num : list_2)
            res[index++] = num;

        return res;
    }

    // Hashmap
    public int[] intersect_2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            int count = hashMap.getOrDefault(nums1[i], 0) + 1;
            hashMap.put(nums1[i], count);
        }
        int[] res = new int[nums1.length];
        int resIndex = 0;
        for (int i = 0; i < nums2.length; ++i) {
            int count = hashMap.getOrDefault(nums2[i], 0);
            // if the value exist
            if (count > 0) {
                res[resIndex++] = nums2[i];
                --count;
                // Still exist, refresh the count
                if (count > 0)
                    hashMap.put(nums2[i], count);
                else
                    hashMap.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(res, 0, resIndex);
    }
}
