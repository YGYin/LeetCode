package round1.hot100.array;

import java.util.HashSet;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        // 缺失的第一个正数
        // O(n) 空间复杂度，将所有数存入 set 中，
        // i = 0从头遍历 nums，不存在 i 立刻返回，都存在返回 len + 1
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++)
            set.add(nums[i]);
        for (int i = 0; i < len; i++)
            if (!set.contains(i))
                return i;

        return len + 1;
    }
}
