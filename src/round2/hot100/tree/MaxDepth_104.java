package round2.hot100.tree;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        // 后序遍历，返回当前层的深度（高度）
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
