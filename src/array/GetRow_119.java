package array;

import java.util.ArrayList;
import java.util.List;

public class GetRow_119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }
            lists.add(row);
        }
        return lists.get(rowIndex);
    }

    public List<Integer> getRow_2(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    cur.add(1);
                else
                    cur.add(pre.get(j - 1) + pre.get(j));
            }
            pre = cur;
        }
        return pre;
    }


}
