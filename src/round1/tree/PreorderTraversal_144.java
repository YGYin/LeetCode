package round1.tree;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traversal(res, root);
        return res;
    }

    private void traversal(List<Integer> res, TreeNode root) {
        res.add(root.val);
        traversal(res, root.left);
        traversal(res, root.right);
    }
}
