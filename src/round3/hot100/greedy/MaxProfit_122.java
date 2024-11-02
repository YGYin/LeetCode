package round3.hot100.greedy;

public class MaxProfit_122 {
    /*
        买卖股票的最佳时机 II
        可以在每天任意购买或者卖出股票
        求最大利润，类似于最大数组和，贪每天的正利润，利润小于 0 就不要
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int profit = 0;
        // 于最大子数组不同的是，不要求连续
        // 大于 0 直接累加，小于 0 不需要重置当前利润
        for (int i = 1; i < prices.length; i++)
            if (prices[i] - prices[i - 1] > 0)
                profit += prices[i] - prices[i - 1];

        return profit;
    }
}
