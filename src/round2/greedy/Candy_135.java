package round2.greedy;

import java.util.Arrays;

public class Candy_135 {
    /*
        分发糖果
        贪心，先初始化 candy 数组全部为 1
        1. 先从左到右，如果当前元素比前一个大则分发糖果数 + 1
        2. 再从右到左，如果当前元素比后一个大则分发糖果数 + 1，两次遍历 candy[i] 要取较大值
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 1)
            return 1;

        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        int res = 0;
        // 从左到右，如果当前元素比前一个大则分发糖果数 + 1
        for (int i = 1; i < len; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;

        // 从右到左，如果当前元素比后一个大则分发糖果数 + 1，两次遍历 candy[i] 要取较大值
        for (int i = len - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);

        // 遍历 candies，得到糖果总和
        for (int num : candies)
            res += num;

        return res;
    }
}
