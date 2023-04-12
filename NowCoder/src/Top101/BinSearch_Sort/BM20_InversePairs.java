package Top101.BinSearch_Sort;

public class BM20_InversePairs {
    public int mod = 1000000007;

    public int InversePairs(int[] array) {
        int length = array.length;
        int[] temp = new int[length];
        return mergeSort(0, length - 1, array, temp);
    }

    int mergeSort(int left, int right, int[] arr, int[] temp) {
        if (left >= right)
            return 0;
        int mid = (left + right) / 2;
        // 左右划分合并
        int res = mergeSort(left, mid, arr, temp) + mergeSort(mid + 1, right, arr, temp);
        //防止溢出
        res %= mod;
        int lPtr = left, rPtr = mid + 1;
        for (int i = left; i <= right; i++)
            temp[i] = arr[i];
        for (int i = left; i <= right; i++) {
            // 左半结束
            if (lPtr == mid + 1)
                arr[i] = temp[rPtr++];
                // 右半结束 或者左边小于右边
            else if (rPtr == right + 1 || temp[lPtr] <= temp[rPtr])
                arr[i] = temp[lPtr++];
                // 左边大于右边，符合逆序对
            else {
                arr[i] = temp[rPtr++];
                // 统计逆序对
                res += mid - lPtr + 1;
            }
        }
        return res % mod;
    }
}
