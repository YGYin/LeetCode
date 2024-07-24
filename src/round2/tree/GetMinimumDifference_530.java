package round2.tree;

public class GetMinimumDifference_530 {
    /*
        二叉搜索树的最小绝对差
        和判断二叉搜索树思路相近，同样是中序遍历用双指针和前一节点比较值，更新最小绝对差
     */

    // 用于记录前一节点的值
    TreeNode prev = null;
    int minDiffVal = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        getMinDiffVal(root);
        return minDiffVal;
    }

    // 1. 用 minDiffVal 来记录最小差值，无需返回值，传入当前根节点
    private void getMinDiffVal(TreeNode root) {
        // 结束条件 节点为空时返回
        if (root == null)
            return;

        // 左
        getMinDiffVal(root.left);
        // 中，比较当前节点值和前一节点的差值，更新最小差值，前提是 前一节点不为空
        if (prev != null)
            minDiffVal = Math.min(minDiffVal, root.val - prev.val);
        // 更新指针
        prev = root;
        // 右
        getMinDiffVal(root.right);
    }
}
