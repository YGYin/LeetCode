package round1.tree;

import java.util.ArrayList;
import java.util.List;

public class FindMode_501 {
    // 记录出现频次最高的元素
    List<Integer> resList;
    int count;
    int maxCount;
    // 双指针遍历
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        // 初始化
        resList = new ArrayList<>();
        count = 0;
        maxCount = 0;
        pre = null;

        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);

        return res;
    }

    // 1. 不需要返回参数，传入根节点，二叉搜索树 -> 中序遍历
    private void traversal(TreeNode root) {
        // 2. 结束条件
        if (root == null)
            return;
        // 左
        traversal(root.left);
        // 中，三种情况
        // a. pre 指针为空，说明为第一个节点，count = 1
        // c. pre 和 cur 值不相等，count = 1
        if (pre == null || pre.val != root.val)
            count = 1;
            // b. pre.val == cur.cal，count ++
        else
            ++count;
        // 更新 count 后也应该更新 maxCount
        // count > maxCount，需要清空之前 resList 的元素，再添加当前元素
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        } else if (count == maxCount)
            resList.add(root.val);

        // 向前移动 pre 指针
        pre = root;

        // 右边
        traversal(root.right);
    }
}
