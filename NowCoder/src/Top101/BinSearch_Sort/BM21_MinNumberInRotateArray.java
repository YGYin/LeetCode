package Top101.BinSearch_Sort;

import java.util.Arrays;

public class BM21_MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length <= 1)
            return array[0];
        Arrays.sort(array);
        return array[0];
    }

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
