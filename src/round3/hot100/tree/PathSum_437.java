package round3.hot100.tree;

public class PathSum_437 {
    /*
        路径总和 III
        双重递归
        1. 定义 rootSum 求表示以 root 为起点且向下满足路径总和为 val 的路径数目
        2. 先求 rootSum，再分别遍历左右节点，以它们作为起点求满足总和为 val 的路径数目
     */
    // pathSum 用于遍历树本身，前序遍历
    // 然后定义 rootSum 来以当前节点为根节点向下寻找满足和为 targetSum 的路径
    public int pathSum(TreeNode root, int targetSum) {
        // 判空
        if (root == null)
            return 0;

        // 中，以当前节点作为根节点向下遍历
        int res = rootSum(root, targetSum);
        // 左右
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    // 同样返回满足和为 targetSum 的路径数量，传入当前根节点和当前的目标和
    // 经过当前节点就减去节点的值
    private int rootSum(TreeNode root, long targetSum) {
        if (root == null)
            return 0;

        // 定义 res 记录当前节点开始遍历满足 targetSum 的路径数
        int res = 0;

        // 中：因为每次经过一个节点，传入 targetSum - root.val
        // 如果 targetSum 刚好被减剩等于当前节点 root.val，说明找到满足的路径记录结果
        if (root.val == targetSum)
            ++res;
        // 左右
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }
}
