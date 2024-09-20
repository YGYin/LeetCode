package round2.hot100.tree;

public class PathSum_437 {
    /*
        路径总和 III
        双重递归
        1. 定义 rootSum 求表示以 root 为起点且向下满足路径总和为 val 的路径数目
        2. 先求 rootSum，再分别遍历左右节点，以它们作为起点求满足总和为 val 的路径数目
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 判空
        if (root == null)
            return 0;

        // 当前节点作为根节点时，向下遍历满足路径总和为 val 的路径数目
        int res = rootSum(root, targetSum);
        // 分别再遍历左子树和右子树求路径数目
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    // 返回路径总和为 target 的路径数量
    private int rootSum(TreeNode root, long targetSum) {
        int res = 0;
        if (root == null)
            return 0;

        // 获得当前值，如果被减剩等于 targetSum 即记录为结果
        if (root.val == targetSum)
            ++res;

        // 以此节点为根节点，分别向左右遍历
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);

        return res;
    }
}
