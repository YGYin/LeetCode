package round1.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    // 左中右
    // 传入根节点，无需返回值
    private void traversal(TreeNode root) {
        // 结束条件：遍历到空结束
        if (root == null)
            return;
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }
}
