package round2.greedy;

public class CanCompleteCircuit_134 {
    /*
        加油站
        贪心：主要贪累加每个加油站的剩余油量，如果剩余油量为负数则从下一个油站为起始点
        与最大子序和类似
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 记录当前剩余油量和以及总剩余油量和
        int curSum = 0;
        int totalSum = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            // 先更新当前油站和以及总油站和
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);
            // 看当前剩余油量是否为负数，为负数则从下一个油站为起始点
            if (curSum < 0) {
                startIndex = i + 1;
                curSum = 0;
            }
        }
        // 判断 totalSum 是否小于 0，如果小于 0 说明在所有位置都不存在解
        if (totalSum < 0)
            return -1;
        return startIndex;
    }
}
