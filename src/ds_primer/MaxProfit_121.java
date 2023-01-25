package ds_primer;

public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int res = 0;
        for (int num : prices) {
            minVal = Math.min(minVal, num);
            res = Math.max(res, num - minVal);
        }
        return res;
    }
}
