package round1.tree;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(res, root);
        return res;
    }

    private void traversal(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        traversal(res, root.left);
        traversal(res, root.right);
        res.add(root.val);
    }
}
