package job.dcits;

public class CountPrimes_204 {
    /*
        计数质数
        考虑质数定义:
        在大于 1 的自然数中，除了 111 和它本身以外不再有其他因数的自然数
        从小到大枚举[2, x - 1]中的每个数 y，判断 y 是否为 x 的因数
        因为 y 如果是 x 的因数，x / y 也必然是 x 的因数，
        只需校验 x / y 即可
     */
    public int countPrimes(int n) {
        int count = 0;
        // 求所有小于非负整数 n (不包括 n)的质数的数量
        for (int i = 0; i < n; i++)
            if (isPrime(i))
                ++count;
        return count;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i <= x; i++)
            // 如果能被其他数整除说明有除了自己以外的因数
            if (x % i == 0)
                return false;

        return true;
    }
}
