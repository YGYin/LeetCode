package coding.treenode;

public class HasPathSum_10 {
    // DFS: 前序遍历
    // 因为并不需要遍历整棵树，所以递归函数需要右返回值，可以用 bool
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return traversal(root, targetSum);
    }

    private boolean traversal(TreeNode root, int targetSum) {
        // 结束条件：到达叶子节点且 targetSum 为 0
        if (root.left == null && root.right == null)
            return targetSum - root.val == 0;

        // 因为终止条件是判断叶子节点，所以递归的过程中不要让空节点进入递归
        // 左，一边向左遍历后回溯
        if (root.left != null)
            if (traversal(root.left, targetSum - root.val))
                return true;

        // 右，一边向右遍历后回溯
        if (root.right != null)
            if (traversal(root.right, targetSum - root.val))
                return true;

        return false;
    }
}
