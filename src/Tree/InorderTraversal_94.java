package Tree;

import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_94 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }

}
