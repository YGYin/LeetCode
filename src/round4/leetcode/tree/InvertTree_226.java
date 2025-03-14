package round4.leetcode.tree;

public class InvertTree_226 {
    /*
        翻转二叉树
        中的操作 交换左子树和右子树的节点，不能中序遍历，会重复翻转
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        // 前序或者后序
        invertTree(root.left);
        invertTree(root.right);
        // 交换左右子节点
        swapTreeNode(root);
        return root;
    }

    private void swapTreeNode(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
