package round3.hot100.tree;

public class MaxPathSum_124 {
    /*
        二叉树中的最大路径和
        类似于 543.二叉树的直径，求深度同时再用变量记录左右子树最深深度
        只是 getDepth 含义本身变为求包含 root 的左子树或右子树的最大值
     */
    // 和求最大直径类似，需要定义全局变量记录最大路径和
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        getMaxPathSum(root);
        return maxPathSum;
    }

    // 返回类似于最大深度，不过为节点的值
    private int getMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftVal = getMaxPathSum(root.left);
        int rightVal = getMaxPathSum(root.right);

        // 更新最大路径和
        maxPathSum = Math.max(leftVal + rightVal + root.val, maxPathSum);
        // 返回当前路径最大和，有可能相加为负数，0 等价于不取
        return Math.max(Math.max(leftVal, rightVal) + root.val, 0);
    }
}
