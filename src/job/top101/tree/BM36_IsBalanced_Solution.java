package job.top101.tree;

public class BM36_IsBalanced_Solution {
    /*
        判断是否为平衡二叉树
        比较高度，后序遍历
        1. 参数：传入当前节点，返回当前节点为根节点的树的高度
            需要标记左右子树差值大于 1，不是平衡二叉树时返回高度无意义
            如果已经不是平衡二叉树了，返回 -1
     */
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        return getHeight(pRoot) != -1;
    }

    private int getHeight(TreeNode root) {
        // 2. 终止条件，遇到空节点则高度为 0
        if (root == null)
            return 0;
        // 3. 单层逻辑，
        // 分别获取左指数和右子树的高度，注意先判断左右子树返回的是否为高度还是 -1
        // 差值小于等于 1 的话就返回当前二叉树的高度，否则返回 -1
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        // 然后看左右子树的高度差
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }
}
