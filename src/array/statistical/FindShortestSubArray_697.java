package array.statistical;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray_697 {
    public int findShortestSubArray(int[] nums) {
        // Initialize a map, Key for nums' value, Value[2] for times, first and last.
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else
                map.put(nums[i], new int[]{1, i, i});
        }

        int count = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int tmp[] = entry.getValue();
            if (tmp[0] > count) {
                count = tmp[0];
                minLen = tmp[2] - tmp[1] + 1;
            } else if (tmp[0] == count)
                minLen = Math.min(minLen, tmp[2] - tmp[1] + 1);
        }
        return minLen;
    }
}
