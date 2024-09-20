package round2.hot100.tree;

public class MaxPathSum_124 {
    /*
        二叉树中的最大路径和
        类似于 543.二叉树的直径，求深度同时再用变量记录左右子树最深深度
        只是 getDepth 含义本身变为求包含 root 的左子树或右子树的最大值
     */
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 判空
        if (root == null)
            return 0;

        getDepth(root);
        return maxPathSum;
    }

    // 求包含当前值的子树最大值
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftVal = getDepth(root.left);
        int rightVal = getDepth(root.right);

        // 路径最大值则为 左子树最大值加上右子树最大值
        maxPathSum = Math.max(maxPathSum, leftVal + rightVal + root.val);
        // 因为有可能相加为负数，需要和 0 比较，相当于不取
        return Math.max(Math.max(leftVal, rightVal) + root.val, 0);
    }

}
