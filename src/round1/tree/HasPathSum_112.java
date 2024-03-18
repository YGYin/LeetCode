package round1.tree;

public class HasPathSum_112 {
    // 1. 返回值为 bool，传入根节点以及目标和，看相减是否为 0
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // 2. 结束条件：
        //      a. 遇到叶子节点判断是否为目标路径(targetSum 被减为 0)
        //      b. 叶子节点，但 targetSum 不等于叶子节点 -> false
        if (root.left == null && root.right == null)
            return targetSum - root.val == 0;

        // 向左递归，先判断递归方向是否为空，再判断递归返回是否满足条件
        // targetSum - root.val
        // if (hasPathSum(root.left, targetSum))
        //            return true;
        // TargetSum + root.val

        if (hasPathSum(root.left, targetSum - root.val))
            return true;

        // 右
        if (hasPathSum(root.right, targetSum - root.val))
            return true;

        return false;
    }

}
