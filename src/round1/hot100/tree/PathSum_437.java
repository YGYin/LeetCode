package round1.hot100.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum_437 {
    int count, target;

    public int pathSum(TreeNode root, int targetSum) {
        /*
         路径总和 III
         求该二叉树里节点值之和等于 targetSum 的 路径 的数目
         路径 不需要从根节点开始，也不需要在叶子节点结束，
         但是路径方向必须是向下的（只能从父节点到子节点）
        */
        // 自顶向下
        // 可以采用双重递归方法
        // 1. dfs1 用于遍历所有节点
        // 2. dfs2 用于搜索，基于当前节点为根的所有向下且累计和为 targetSum 的路径
        target = targetSum;
        dfs1(root);
        return count;
    }

    // 遍历所有节点，无需返回值，传入根节点，前序遍历，将每一个当前节点做为根
    private void dfs1(TreeNode root) {
        if (root == null)
            return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    // 搜索基于当前节点为根的所有向下且累计和为 targetSum 的路径
    // 无需返回值，传入当前节点和对应值
    private void dfs2(TreeNode root, long val) {
        if (val == target)
            ++count;
        if (root.left != null)
            dfs2(root.left, val + root.left.val);
        if (root.right != null)
            dfs2(root.right, val + root.right.val);
    }
}
