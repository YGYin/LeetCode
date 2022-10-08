package array.traversal;

public class FindMaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                ++count;
            else {
                result = Math.max(result, count);
                count = 0;
            }
        }
        result = Math.max(result, count);
        return result;
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1)
                ++count;
            else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        result = Math.max(count, result);
        return result;
    }
}




