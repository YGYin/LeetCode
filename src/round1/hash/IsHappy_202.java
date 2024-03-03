package round1.hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy_202 {
    // 题目提到求 n 的每个位置上的平方和过程中可能无限循环始终变不到 1
    // 说明 n 有可能重复出现，但重复出现且不等于 1 时为 false
    public boolean isHappy(int n) {
        // 元素个数多，且需记录是否出现 -> set
        Set<Integer> set = new HashSet<>();
        // 在 n != 1 且未出现重复时重复计算平方和
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            // 计算平方和
            n = getNextN(n);
        }
        return n == 1;
    }

    private int getNextN(int n) {
        int nextN = 0;
        // 分别取 n 每个位置的平方和，不断 mod 10
        while (n > 0) {
            int temp = n % 10;
            nextN += temp * temp;
            // 更新 n
            n /= 10;
        }
        return nextN;
    }
}
