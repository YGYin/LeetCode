package round2.hot100.tree;

public class InvertTree_226 {
    /*
        翻转二叉树
        可以用前序或者后序遍历进行翻转，
        不能使用中序遍历，会导致已经翻转的左边子树翻转到右边后又重复被翻转
     */

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        // 后序遍历，先翻转左子树，再翻转右子树，再交换左右子树
        // 分别先向左右遍历
        invertTree(root.left);
        invertTree(root.right);
        // 中间逻辑，翻转子节点
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
