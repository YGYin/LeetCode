package round1.tree;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // 后序遍历返回子节点高度信息
    // 1. 返回值为子节点的高度，传入根节点
    private int getHeight(TreeNode node) {
        // 返回终止条件，递归到空节点时高度为 0 向上返回
        if (node == null)
            return 0;
        // 检查左子树是否高度差
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        // 右
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;
        // 中
        // 处理逻辑：得到左右子树情况后，才能比较子树高度差超过 1 时返回 -1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
            // 符合平衡二叉树条件时，父节点的高度应该为左右子树高度的最大值 + 1
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }
}
