package round1.hot100.tree;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        // 对称二叉树，需要比较左右子树是否轴对称
        if (root == null)
            return true;
        // 传入左右子树，返回 boolean
        return compareTree(root.left, root.right);
    }

    private boolean compareTree(TreeNode left, TreeNode right) {
        // 通过比较左右子树是否为空的情况作为终止条件
        if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;

        // 比较子树的外内侧
        boolean outside = compareTree(left.left, right.right);
        boolean inside = compareTree(left.right, right.left);
        return outside && inside;
    }
}
