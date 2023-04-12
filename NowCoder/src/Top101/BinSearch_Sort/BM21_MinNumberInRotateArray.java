package Top101.BinSearch_Sort;

import java.util.Arrays;

public class BM21_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length <= 1)
            return array[0];
        Arrays.sort(array);
        return array[0];
    }

    /*
        step 1: 双指针指向旋转后数组的首尾，作为区间端点。
        step 2: 若是区间中点值大于区间右界值，则最小的数字一定在中点右边。
        step 3: 若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
        step 4: 若是区间中点值小于区间右界值，则最小的数字一定在中点左边。
        step 5: 通过调整区间最后即可锁定最小值所在
        O(logn) / O(1)
     */
    public int minNumberInRotateArray_2(int[] array) {
        int n = array.length;
        if (n <= 1)
            return array[0];
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right])
                left = mid + 1;
            else if (array[mid] == array[right])
                --right;
                // 与普通二分搜索目标值不同
                // 最小数字要么是 mid 要么在 mid 左边
            else
                right = mid;
        }
        return array[left];
    }

}
