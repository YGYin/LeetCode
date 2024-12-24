package round3.hot100.tree;

public class InvertTree_226 {
    /*
        翻转二叉树
        交换左子树和右子树的节点，不能中序遍历，会重复翻转
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        // 前序遍历或者后序遍历
        invertTree(root.left);
        invertTree(root.right);
        swapNode(root);
        return root;
    }

    private void swapNode(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
