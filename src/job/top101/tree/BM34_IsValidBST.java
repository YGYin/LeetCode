package job.top101.tree;

import java.util.ArrayList;
import java.util.List;

public class BM34_IsValidBST {
    /*
        判断是否为二叉搜索树
        1. 利用二叉搜索树中序遍历为升序的性质判断
     */

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) >= list.get(i + 1))
                return false;
        return true;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
