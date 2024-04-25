package round1.hot100.tree;

public class MaxPathSum_124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // 返回当前根节点及其子树的最大路径和，传入当前节点
    private int dfs(TreeNode root) {
        // 当前节点为空，则为 0
        if (root == null)
            return 0;

        // 后序遍历，分别获取左右子树的最大路径和
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        // 当前根节点及其子树内部最大路径和（不进入递归），同时选取左右子树
        // 并尝试更新最大路径和
        int curTreeSum = root.val + leftVal + rightVal;
        maxSum = Math.max(maxSum, curTreeSum);

        // 同时，要返回当前子树路径能够对外(其他树)提供的最大和（进入递归）
        // 相当于只选取左子树路径或者右子树路径，用于传递给父节点
        // 有三种选择，要么停留在当前节点，要么向左，要么向右
        int outputSum = root.val + Math.max(0, Math.max(leftVal, rightVal));

        return outputSum < 0 ? 0 : outputSum;
    }
}
