package round1.hot100.greedy;

public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        // 买卖股票的最佳时机
        // 定义最低价格以及最大利益
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // 遍历价格
        for (int i = 0; i < prices.length; i++) {
            // 看价格是否有变化，比当前最低价低就买进
            if (prices[i] < minPrice)
                minPrice = prices[i];
                // 因为买进当天不会卖出，同时也可以选择不卖出
                // 所以用 else if
                // 每天都考虑今天卖出，依次求出每个卖出时机的最大差值
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }
}
