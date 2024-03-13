package round1.tree;

public class IsSymmetric_101 {
    // 使用后序遍历，左右孩子的信息才能回传给根节点
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }

    // 1. 确定递归返回值和参数
    //    需要比较左右子树是否对称，返回 bool，传入节点的左右子树
    private boolean compare(TreeNode left, TreeNode right) {
        // 2. 终止条件：左为空，右不为空或相反情况都说明左右子树不同 -> false
        //             左右都为空说明相同可翻转 -> true
        //             左右都不为空但值不相等 -> false
        //             左右都不为空且值相等 -> 向下遍历 (第三部的处理逻辑)
        if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        else if (left == null && right == null)
            return true;
        else if (left.val != right.val)
            return false;
        // 左，比较树的外侧 -> 左节点的左孩子和右节点的右孩子
        boolean outside = compare(left.left, right.right);
        // 右，比较树的内侧 -> 左节点的右孩子和右节点的左孩子
        boolean inside = compare(left.right, right.left);
        // 中，只有左右同时为 true 时才 true
        return outside && inside;
    }
}
