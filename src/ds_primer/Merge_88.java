package ds_primer;

import java.util.Arrays;

public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        for (int i = 0; i != n; ++i)
            nums1[m + i] = nums2[i];

        Arrays.sort(nums1);
    }

    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int mPtr = 0, nPtr = 0;
        int temp = 0, count = 0;
        int[] sorted = new int[m + n];
        while (mPtr < m || nPtr < n) {
            if (mPtr == m)
                temp = nums2[nPtr++];
            else if (nPtr == n)
                temp = nums1[mPtr++];
            else if (nums1[mPtr] <= nums2[nPtr]) {
                temp = nums1[mPtr++];
            } else
                temp = nums2[nPtr++];
            sorted[count++] = temp;
        }
        for (int i = 0; i < m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}
