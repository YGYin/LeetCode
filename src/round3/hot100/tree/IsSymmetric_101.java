package round3.hot100.tree;

public class IsSymmetric_101 {
    /*
        对称二叉树
        需要比较内侧和外侧是否相等，首先需要比较根节点的左右节点是否相等
        1. 返回是否对称，传入左子节点和右子节点
        2. 因为传入左右节点，需要对两个节点分别四种为空的情况进行判断，都为空则为对称
        3. 中间逻辑：分别比较外侧和内侧是否相等
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }

    // 返回是否对称，传入左子节点和右子节点
    private boolean compare(TreeNode left, TreeNode right) {
        // 对两个节点分别四种为空的情况进行判断，都为空则为对称
        if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        else if (left == null && right == null)
            return true;
            // 都不为空需要比较值
        else if (left.val != right.val)
            return false;

        // 判断是否对称分别比较内和外
        boolean inside = compare(left.right, right.left);
        boolean outside = compare(left.left, right.right);
        return inside && outside;
    }
}
