package round1.hot100.greedy;

public class MaxProfit_122 {
    public int maxProfit(int[] prices) {
        // 买卖股票的最佳时机 II
        /*
            最佳时机 I 是单笔交易中能够获得的最大利润
            最佳时机 II 是可以当天和隔天多次交易，但每次最多只能持有一股
            求最终最大利润总和
            -> 贪心
            -> S[3] - S[0] = (S[3] - S[2]) + (S[2] - S[1]) + (S[1] - S[0])
            -> 可以每天都买第二天卖，贪每一天的正收益
         */
        int totalMaxProfit = 0;
        // 从第二天才能卖出考虑收益，只贪正收益
        for (int i = 1; i < prices.length; i++)
            totalMaxProfit += Math.max(prices[i] - prices[i - 1], 0);

        return totalMaxProfit;
    }
}
