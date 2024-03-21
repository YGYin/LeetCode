package round1.tree;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference_530 {
    List<Integer> list;

    public int getMinimumDifference(TreeNode root) {
        // 二叉搜索树 -> 中序遍历得到有序数组
        // 遍历有序数组求两个数之间的最小差
        list = new ArrayList<>();
        traversal(root);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < list.size() - 1; i++)
            minDiff = Math.min(minDiff, list.get(i + 1) - list.get(i));

        return minDiff;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
