package array.traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class ThirdMax_414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int num : nums) {
            tree.add(num);
            if (tree.size() > 3)
                tree.remove(tree.first());
        }
        return tree.size() == 3 ? tree.first() : tree.last();
    }

    public int thirdMax_2(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 0, diffNum = 1; i < nums.length - 1; ++i)
            if (nums[i] != nums[i + 1] && ++diffNum == 3)
                return nums[i + 1];
        return nums[0]; // The num of difference < 3, return the max one
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1, temp = 0;
        while (left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

}
