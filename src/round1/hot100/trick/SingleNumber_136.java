package round1.hot100.trick;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {
    /*
        136. 只出现一次的数字
        ！每个元素均出现两次，只有某个元素 ele 只出现一次
        任何数和 0 做异或运算，结果仍然是原来的数，即 a xor 0 = a
        任何数和其自身做异或运算，结果是 0，即 a xor a = 0
        异或运算满足交换律和结合律
        进行 xor 运算后会只剩下 0 xor ele = ele
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        // 要求线性时间，遍历一遍数组，并且只能用常数级的额外空间
        for (int i = 0; i < nums.length; i++)
            res ^= nums[i];

        return res;
    }
}
