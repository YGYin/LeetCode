package round3.hot100.tree;

public class MaxDepth_104 {
    // 返回当前深度（高度）
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 后序遍历返回深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
