package Top101.sort;

public class MergeSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        mergeSort(arr, 0, arr.length - 1, new int[]{});
    }

    void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left == right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = 0;
        int lPtr = left;
        int rPtr = mid + 1;
        // 比较左右两部分，哪个小就填入 temp 数组中
        while (lPtr <= mid && rPtr <= right)
            temp[i++] = arr[lPtr] < arr[rPtr] ? arr[lPtr++] : arr[rPtr++];
        // 将剩余部分元素依次填入到 temp 中
        while (lPtr <= mid)
            temp[i++] = arr[lPtr++];
        while (rPtr < right)
            temp[i++] = arr[rPtr++];
        // 把最终排序的结果复制给原数组
        for (i = 0; i < temp.length; i++)
            arr[left + i] = temp[i];

    }
}
