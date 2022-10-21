package array;

/*
反转思考问题，每次有 n - 1 个元素加一达到所需最大值maxVal
- 即每次有一个元素减一达到数组目前的最小值 minVal
    1. 遍历数组得到最小值
    2. 遍历数组，累加每个数与最小值的差值则为需要做减一的最小操作次数
 */
public class MinMoves_453 {
    public int minMoves(int[] nums) {
        int minVal = Integer.MAX_VALUE, ans = 0;
        for (int x : nums)
            minVal = Math.min(minVal, x);

        for (int x : nums)
            ans += (x - minVal);

        return ans;
    }
}
