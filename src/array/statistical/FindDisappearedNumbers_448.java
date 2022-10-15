package array.statistical;

import java.util.*;
import java.util.zip.Adler32;

public class FindDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i)
            set.add(nums[i]);
        for (int i = 1; i <= n; ++i)
            if (set.add(i))
                res.add(i);
        return res;
    }

    public List<Integer> findDisappearedNumber_2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] set = new int[n + 1];
        int tmp;
        for (int i = 0; i < n; ++i) {
            tmp = nums[i];
            set[tmp] = tmp;
        }
        for (int i = 1; i <= n; i++)
            if (set[i] == 0)
                result.add(i);

        return result;
    }

}
