package Top101.tree;

public class LongestUnivaluePath_687 {
    private int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        getPath(root, root.val);
        return maxLen;
    }

    private int getPath(TreeNode root, int val) {
        if (root == null)
            return 0;
        // 后序遍历
        int left = getPath(root.left, root.val);
        int right = getPath(root.right, root.val);
        // 因为求的为路径数非节点数，此处不加 1
        maxLen = Math.max(maxLen, left + right);
        if (root.val == val)
            return Math.max(left, right) + 1;
        return 0;
    }
}
