package round2.tree;

public class IsSymmetric_101 {
    /*
        对称二叉树
        因为需要对内侧和外侧的节点的值进行比较，
        所以需要先判断其左右节点所有可能为空的情况
     */
    public boolean isSymmetric(TreeNode root) {
        // 根节点节点为空时，也为对称
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }

    // 需要传入根节点的两侧子节点，返回两个节点值是否相同
    private boolean compare(TreeNode left, TreeNode right) {
        // 因为需要对内侧和外侧的节点的值进行比较，
        // 所以需要先判断其左右节点所有可能为空的情况
        if (left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if (left == null && right == null)
            return true;
            // 都不为空，则比较两个节点的值是否相等
        else if (left.val != right.val)
            return false;

        // 分别比较树的内侧和外侧是否对称
        boolean inside = compare(left.right, right.left);
        boolean outside = compare(left.left, right.right);
        return inside && outside;
    }
}
