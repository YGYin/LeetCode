package round2.hot100.tree;

public class IsSymmetric_101 {
    /*
        对称二叉树
        需要比较内侧和外侧是否相等，首先需要比较根节点的左右节点是否相等
        1. 返回是否对称，传入左子节点和右子节点
        2. 因为传入左右节点，需要对两个节点分别四种为空的情况进行判断，都为空则为对称
        3. 中间逻辑：分别比较外侧和内侧是否相等
     */
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        // 终止条件：比较左右子节点为空的情况
        if (left == null && right == null)
            return true;
        else if (left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if (left.val != right.val)
            return false;

        // 分别比较内侧和外侧是否相等
        boolean inside = compare(left.right, right.left);
        boolean outside = compare(left.left, right.right);
        return inside && outside;
    }
}
