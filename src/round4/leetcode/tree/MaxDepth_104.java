package round4.leetcode.tree;

public class MaxDepth_104 {
    // 返回当前深度（高度）
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 后序遍历，最后返回之前的最大深度 + 1（当前深度）
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
