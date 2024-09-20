package round2.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest_230 {
    /*
        二叉搜索树中第 K 小的元素
        利用二叉搜索树的性质，中序遍历存到 list 中，返回下标第 k - 1 个元素
     */
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
