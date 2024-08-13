package round2.dp.bag01;

import java.util.Scanner;

public class sample {

    /*
    1. dp[j]: 容量为 j 的背包最大的价值为 dp[j]
    2. 递推公式:
        - 不要物品 i: dp[j]
        - 要物品 j: dp[j] - weight[i]] + value[i]
        dp[j] = max(dp[i], dp[j]-weight[i] + value[j])
    3. 初始化:
        可以都初始化为非负数
    4. 遍历顺序:
        压缩状态后的一维数组需要先物品后背包，
        同时要从后往前遍历，否则无法利用上一层的结果
*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 获取物品种类个数和行李空间
        int m = sc.nextInt();
        int bagWeight = sc.nextInt();

        // 获取每种材料的占用空间和价值
        int[] weight = new int[m];
        int[] val = new int[m];

        for (int i = 0; i < m; i++)
            weight[i] = sc.nextInt();

        for (int i = 0; i < m; i++)
            val[i] = sc.nextInt();

        // 初始化 dp 数组
        int[] dp = new int[bagWeight + 1];

        // 先物品后背包
        for (int i = 0; i < m; i++) {
            // 一维数组要倒序遍历
            for (int j = bagWeight; j >= weight[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + val[i]);
        }

//        二维数组
//
//        // weight 数组的大小 就是物品个数
//        for (int i = 1; i < weight.size(); i++) { // 遍历物品
//            for (int j = 0; j <= bagweight; j++) { // 遍历背包容量
//                if (j < weight[i])
//                    dp[i][j] = dp[i - 1][j];
//                else
//                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
//            }
//        }
//

        System.out.println(dp[bagWeight]);
    }
}

