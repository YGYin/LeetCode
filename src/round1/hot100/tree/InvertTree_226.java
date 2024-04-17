package round1.hot100.tree;

public class InvertTree_226 {
    // 也可以用层序遍历实现，在取得该层节点时先 swap 左右子树然后再添加进队列
    public TreeNode invertTree(TreeNode root) {
        // 传入根节点，返回根节点
        // 当遍历为空时返回
        if (root == null)
            return root;
        // 采用前序遍历，处理节点逻辑为交换左右子树(指针)
        swapNode(root);
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
