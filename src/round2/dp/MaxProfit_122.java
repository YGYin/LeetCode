package round2.dp;

public class MaxProfit_122 {
    /*
        买卖股票的最佳时机 II
        I 只能买卖一次，每天可以多次买卖同一支股票，但最多只能持有一股股票
        相当于每天都贪正收益，相比昨天有正收益就卖
        求总的最大利润，累加每一次的正收益
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 遍历数组，因为从第二天出售前一天股票才有收益，所以从 1 开始遍历
        for (int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i - 1]);

        return profit;
    }
}
