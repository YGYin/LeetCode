package round2.greedy;

public class LemonadeChange_860 {
    /*
        柠檬水找零
        分析找零情况，只有 10 元和 5 元可以拿来找零
        1. 给 5 元 -> 直接收下
        2. 给 10 元 -> 10 元张数 + 1，5 元张数 - 1
        3. 给 20 元 -> 优先找 10 元 + 5 元，如果没有 10 元则找 3 张 5 元

        记录 5 元和 10 元的总张数，看遍历完数组后是否有负数
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5)
            return false;
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            // 分类讨论给 5 元 10 元 20 元的情况
            if (bills[i] == 5)
                ++five;
            else if (bills[i] == 10) {
                --five;
                ++ten;
            } else {
                // 如果有 10 元则找回 10 + 5，没有则找 3 张 5 元
                if (ten > 0) {
                    --ten;
                    --five;
                } else
                    five -= 3;
            }
            // 如果找完钱后，10 元或者 5 元张数小于 0 则没有办法找钱
            if (five < 0 || ten < 0)
                return false;
        }

        return true;
    }
}
