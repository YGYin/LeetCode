package round4.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {

    // 记录结果
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        // 结束条件
        if (root == null)
            return;
        // 左中右
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
