package job.top101.tree;

public class BM33_Mirror {
    /*
        二叉树的镜像
        交换根节点的左右节点
     */
    // 1. 传入根节点，返回镜像二叉树的根节点
    public TreeNode Mirror(TreeNode pRoot) {
        // 2. 当遍历到空节点的时候返回（到底）
        if (pRoot == null)
            return null;
        // 前序遍历，交换该节点的左右子节点
        swapNode(pRoot);
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    private void swapNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
