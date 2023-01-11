public class IsPrime {
    // 判断 val 是否为素数
    boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // 给数组找出第 n 个素数, count != 0
    int isPrime_2(int[] nums, int n) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i]))
                ++count;
            if (count == n)
                return nums[i];
        }
        return 0;
    }
}
