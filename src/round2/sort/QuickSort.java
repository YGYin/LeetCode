package round2.sort;

import java.util.Arrays;

public class QuickSort {
    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // 划分函数，选定
            int pivot = partition(nums, left, right);
            // 排序左半部份
            quickSort(nums, left, pivot - 1);
            // 排序右半部分
            quickSort(nums, pivot + 1, right);
        }
    }

    // 划分函数，找到基准元素的正确位置
    private int partition(int[] nums, int left, int right) {
        System.out.println("================");
        // 默认选择当前区间的最右侧的一个元素作为 pivot
        int pivot = nums[right];
        int i = left;
        for (int j = left + 1; j < right; j++) {
            // 如果 j 指向的元素小于 pivot，则和 i 交换
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        // 交换完将 pivot 放到正确位置
        swap(nums, i, right);
        System.out.println(Arrays.toString(nums));
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 8, 9, 1, 5};
        System.out.println(Arrays.toString(nums));
        QuickSort sort = new QuickSort();
        sort.quickSort(nums, 0, nums.length - 1);
    }
}
