package round1.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        // 二叉搜索树中第K小的元素
        // 利用二叉搜索树中序遍历为递增数组的性质
        traversal(root);
        return list.get(k - 1);
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
