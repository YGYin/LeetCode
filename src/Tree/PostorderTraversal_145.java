package Tree;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal_145 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }
}
