package round3.hot100.tree;

public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        // 本身为空，返回 0
        if (root == null)
            return 0;

        // 后序遍历，同样先获取两边子树深度
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 需要对看左右子树有没有单独一遍为空的情况
        if (root.left != null && root.right == null)
            return 1 + leftDepth;
        if (root.left == null && root.right != null)
            return 1 + rightDepth;
        // 都不为空返回两侧的最小值 + 1
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
