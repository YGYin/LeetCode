package round2.dp.profit;

public class MaxProfit_121 {
    /*
        买卖股票的最佳时机
        某一天买进，选择再某个不同日子再卖出，只能买卖一次
        1. 贪心：贪最低点买进，向左取最小值，向右取最大值
     */
    public int maxProfit_1(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            // 贪最低价格
            lowestPrice = Math.min(lowestPrice, prices[i]);
            // 更新最大利益
            profit = Math.max(profit, prices[i] - lowestPrice);
        }

        return profit;
    }
}
