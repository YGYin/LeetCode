package array.statistical;

import java.util.Arrays;
import java.util.HashMap;

public class FindErrorNums_645 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int n = nums.length, prev = 0, curr;
        for (int i = 0; i < n; i++) {
            curr = nums[i];
            if (curr == prev)
                res[0] = prev;
            else if (curr - prev > 1)
                res[1] = prev + 1;
            prev = curr;
        }
        if (nums[n - 1] != n)
            res[1] = n;
        return res;
    }

    // HashMap:Time and space are both O(N)
    public int[] findErrorNums_2(int[] nums) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (int i = 1; i <= n; ++i) {
            int count = map.getOrDefault(i, 0);
            if (count == 2)
                res[0] = i;
            else if (count == 0)
                res[1] = i;
        }
        return res;
    }
}
