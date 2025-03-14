package round4.leetcode.tree;

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
        // 因为传入左右节点，需要对两个节点分别四种为空的情况进行判断，都为空则为对称
        if (left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if (left == null && right == null)
            return true;
            // 都不为空，需要比较值是否相等，相等往下继续遍历子树，不相等返回 false
        else if (left.val != right.val)
            return false;

        // 中间逻辑：分别比较外侧和内侧是否相等
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
