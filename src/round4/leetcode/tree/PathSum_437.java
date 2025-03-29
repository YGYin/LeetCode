package round4.leetcode.tree;

public class PathSum_437 {
    /*
        路径总和 III
        双重递归
        1. 定义 rootSum 求表示以 root 为起点且向下遍历满足路径总和为 val 的路径数目
        2. 先求 rootSum，再分别遍历左右节点，以它们作为起点求满足总和为 val 的路径数目
        pathSum 用于遍历树本身, rootSum 以当前节点开始 dfs
     */

    // pathSum 用于遍历树本身，前序遍历
    // 然后定义 rootSum 来以当前节点为根节点向下寻找满足和为 targetSum 的路径
    public int pathSum(TreeNode root, int targetSum) {
        // 判空
        if (root == null)
            return 0;

        // 中，以当前节点为起点且向下遍历满足路径总和为 val 的路径数目
        int res = rootSum(root, targetSum);
        // 使用 pathSum 遍历左右节点
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    // 传入根节点和当前的目标和，返回满足该目标和的路径数量，同样前序遍历
    private int rootSum(TreeNode root, long targetSum) {
        if (root == null)
            return 0;
        // 定义 count 记录当前节点开始遍历满足 targetSum 的路径数
        int count = 0;

        // 中：每次经过一个节点，传入 targetSum - root.val，
        // 如果 targetSum 刚好被减剩等于当前节点 root.val，说明找到满足的路径记录结果
        if (targetSum == root.val)
            ++count;

        // 分别向左右遍历
        count += rootSum(root.left, targetSum - root.val);
        count += rootSum(root.right, targetSum - root.val);
        return count;
    }
}
