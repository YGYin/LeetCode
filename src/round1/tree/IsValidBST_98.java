package round1.tree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST_98 {
    // 验证是否二叉搜索树，中序遍历存入数组看是否为递增数组
    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        traversal(root);

        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) >= list.get(i + 1))
                return false;
        return true;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }

    private long prev = Long.MIN_VALUE;

    public boolean isValidBST_2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        if (!isValidBST(root.left))
            return false;
        // 中
        if (root.val <= prev)  // 不满足二叉搜索树条件
            return false;
        prev = root.val;

        // 右
        return isValidBST(root.right);
    }
}
