package job.top101.tree;

public class BM28_MaxDepth {
    // 1. 需要传入根节点，返回深度
    public int maxDepth(TreeNode root) {
        // 2. 结束调节为遍历到空节点
        if (root == null)
            return 0;
        // 3. 左右中后序遍历，将深度回传给根节点
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
