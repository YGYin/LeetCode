package round1.tree;

public class InvertTree_226 {
    // 需要返回头节点，传入头节点
    public TreeNode invertTree(TreeNode root) {
        // 结束条件，root 为空时返回
        if (root == null)
            return root;
        // 前序遍历
        // 操作逻辑就是交换左右子节点
        swapNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapNode(TreeNode root) {
        TreeNode curNode = root.left;
        root.left = root.right;
        root.right = curNode;
    }
}
