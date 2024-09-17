package round2.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
