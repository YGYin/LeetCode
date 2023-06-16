package coding.hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy_03 {
    /*
        因为快乐数在求和过程中可能无限循环 -> sum 可能会重复出现
        ->  快速判断一个元素是否出现 -> 哈希法(数据不可控) -> set
        1. 使用 set 来判断 sum 是否重复出现，出现即为 false
        2. 不断更新求和
            - 先将 n % 10 得到最右边一位数存到 temp 中
            - 更新 happySum
            - 更新 n = n / 10，相当于直接向右移一位
     */
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        // 继续求和的条件：要么当前数不为 1，且没有包含的数
        while (n != 1) {
            if (record.contains(n))
                return false;
            record.add(n);
            n = getNextHappyNum(n);
        }
        return true;
    }

    private int getNextHappyNum(int n) {
        int happySum = 0;
        while (n > 0) {
            // 最右一位数
            int temp = n % 10;
            happySum += temp * temp;
            n /= 10;
        }
        return happySum;
    }
}
