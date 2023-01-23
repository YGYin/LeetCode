package ds_primer;

import java.util.ArrayList;

public class Intersect_350 {
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
}
