package array;

import java.util.ArrayList;
import java.util.List;

public class Generate_118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }
            lists.add(row);
        }
        return lists;
    }
}
