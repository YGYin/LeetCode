package round4.leetcode.tree;

public class MinDepth_111 {
    // 1. 使用层序遍历，遇到左右为空则返回当前深度
    // 2. 后序遍历，先判断单独一边为空的情况，都不为空再取两边较小的深度 + 1
    //      因为可能存在链表只有左节点或者只有右节点的情况

    // 返回最小深度
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 后序遍历，先获取左右子树最小深度
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 需要检查是否存在只有一边的情况
        if (root.left != null && root.right == null)
            return leftDepth + 1;
        if (root.left == null && root.right != null)
            return rightDepth + 1;
        // 都不为空或者都为空则返回左右的最小深度 + 1
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
