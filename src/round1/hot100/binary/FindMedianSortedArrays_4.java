package round1.hot100.binary;

public class FindMedianSortedArrays_4 {
    // 寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        double median;
        // 总长度为奇数
        if (totalLen % 2 == 1) {
            int midIndex = totalLen / 2;
            median = getKthElement(nums1, nums2, midIndex + 1);
        }
        // 总长度为偶数，中间下标为 totalLen / 2 - 1和 totalLen / 2
        else {
            int midIndex1 = totalLen / 2 - 1;
            int midIndex2 = totalLen / 2;
            median = (getKthElement(nums1, nums2, midIndex1 + 1)
                    + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
        return median;
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        /*
            要找到第 k 小的元素，
            取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
            nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
            nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个

            取 pivot = min(pivot1, pivot2)，
            两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
            所以 pivot 本身最大也只能是第 k-1 小的元素

            如果 pivot = pivot1，
             那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。
             把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             pivot = pivot2 时同理

            由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），
            因此需要修改 k 的值，减去删除的数的个数
         */

        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int kthElement = 0;

        while (true) {
            // 处理边界情况
            // nums1 的元素全都被排除，直接返回 nums2 中当前第 k 小元素
            if (index1 == len1)
                return nums2[index2 + k - 1];
            if (index2 == len2)
                return nums1[index1 + k - 1];
            // 如果 k = 1 直接返回两个数组的最小值
            if (k == 1)
                return Math.min(nums1[index1], nums2[index2]);

            // 处理正常情况
            int halfK = k / 2;
            // 取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
            int newIndex1 = Math.min(index1 + halfK, len1) - 1;
            int newIndex2 = Math.min(index2 + halfK, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            /*
                如果 pivot = pivot1，
                那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。
                把这些元素全部 "删除"，剩下的作为新的 nums1 数组
                    pivot = pivot2 时同理
             */
            if (pivot1 <= pivot2) {
                // 更新 k 和删除后新的 nums1 数组下标
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
