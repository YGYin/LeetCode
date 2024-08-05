package round2.greedy;

public class MaxProfit_122 {
    /*
        买卖股票的最佳时机 II
        多次买卖同一只股票
        拆解为每天的利润 nums[i] - nums[i - 1]
        -> 局部最优: 贪每天的正利润，没有正利润就不买（利润为 0）
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 相对于前一天有正利润就买，没有就不买
        for (int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i - 1]);

        return profit;
    }
}
