package round2.hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy_202 {
    /*
        快乐数
        注意题设说有可能为无限循环，所以需要 set 在每次循环前判断是否有重复
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            // 当前和不存在，加入到 set 中
            set.add(n);
            n = getNextN(n);
        }

        // n 有可能等于 1 也有可能是因为计算过程中产生了重复的数
        // 等于 1 则为快乐数
        return n == 1;
    }

    private int getNextN(int n) {
        // 计算每个位置上的数字的平方和
        int sum = 0;
        // 不断除 10
        while (n > 0) {
            // 取当前的个位数
            int curBit = n % 10;
            sum += curBit * curBit;
            n /= 10;
        }

        return sum;
    }

}
