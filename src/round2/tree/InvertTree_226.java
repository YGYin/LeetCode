package round2.tree;

import round2.tree.TreeNode;

public class InvertTree_226 {
    /*
        翻转二叉树
        可前序或后序，不可中序翻转
     */
    // 不需要返回，传入根节点
    // 也可以传回根节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        // 前序遍历
        // 中，交换左右子节点
        swapNode(root);
        // 分别向左右遍历
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
