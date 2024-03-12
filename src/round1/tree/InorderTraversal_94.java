package round1.tree;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(res, root);
        return res;
    }

    private void traversal(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        traversal(res, root.left);
        res.add(root.val);
        traversal(res, root.right);
    }
}
