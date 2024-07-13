package round2.tree;

public class IsBalanced_110 {
    /*
        判断平衡二叉树
        左右子树的高度绝对值不超过 1，比较高度
        后序遍历
        终止条件：根节点为空则高度为 0
        看左右子节点是否能构成平衡二叉树，如果左右高度为 -1 则说明不为平衡二叉树
        最后计算左右节点高度差绝对值是否 > 1，是则返回 -1，否则返回当前节点最大高度
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return getDepth(root) == -1;
    }

    // 1. 传入当前节点，返回传入节点为根节点的数的高度，要是当前不为平衡二叉树则返回 -1
    private int getDepth(TreeNode root) {
        // 2. 终止条件: 遇到了空节点就终止，高度为 0
        if (root == null)
            return 0;
        // 后序遍历，分别判断左子树和右子树是否不为平衡二叉树
        int leftHeight = getDepth(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getDepth(root.right);
        if (rightHeight == -1)
            return -1;

        // 中
        // 左右子树都为平衡二叉树的话，计算当前节点的左右子树的高度差看是否大于 1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
            // 为平衡二叉树，返回以当前节点为根节点的最大高度
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
}
