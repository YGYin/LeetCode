package round2.tree;

public class HasPathSum_112 {
    /*
        路径总和 I
        主要在于采用减去节点的值方式，判断 count 是否为 0 且到达叶子节点来找到满足的路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 将节点传入到递归方法前先判空
        if (root == null)
            return false;
        return traversal(root, targetSum - root.val);
    }

    // 1. 返回是否存在路径满足使得到达叶子节点 count 为 0，传入当前节点和减去当前节点值的 count
    private boolean traversal(TreeNode root, int count) {
        // 2. 结束条件: 当 count == 0 且到达叶子节点为 true
        if (count == 0 && root.left == null && root.right == null)
            return true;
        // 遇到叶子节点但和不为 0
        if (root.left == null && root.right == null)
            return false;

        // 左节点不为空，向左遍历回溯
        if (root.left != null)
            if (traversal(root.left, count - root.left.val))
                return true;
        // 右
        if (root.right != null)
            if (traversal(root.right, count - root.right.val))
                return true;

        return false;
    }

    // 简化
    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        // 为空则返回 false
        if (root == null)
            return false;
        // 当到达子节点且 count 为 0 时为 true
        if (root.left == null && root.right == null && targetSum == root.val)
            return true;
        // 否则分别向左右遍历且回溯
        // 此处未对 root.left 和 right 判空，只能减去当前节点的值
        return hasPathSum_2(root.left, targetSum - root.val) || hasPathSum_2(root.right, targetSum - root.val);
    }
}


