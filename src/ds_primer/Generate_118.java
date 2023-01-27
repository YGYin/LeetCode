package ds_primer;

import java.util.ArrayList;
import java.util.List;

public class Generate_118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    arr.add(1);
                else
                    arr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(arr);
        }
        return res;
    }
}
