package round2.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_113 {
    /*
        路径总和 II
        和路径总和 I 类似，只是要返回符合的路径
     */
    // 储存路径结果和当前结果
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        // 加入首节点
        path.add(root.val);
        traversal(root, targetSum - root.val);
        return res;
    }

    // 1. 记录路径，不需要返回值，传入节点和减去当前节点值的 count
    private void traversal(TreeNode root, int count) {
        // 2. 结束条件: 判断到达叶子节点时 count 刚好被减为 0
        if (count == 0 && root.left == null && root.right == null) {
            // 收获结果
            res.add(new ArrayList<>(path));
            return;
        }
        // 到达叶子节点当时 count 不为 0
        if (root.left == null && root.right == null)
            return;

        // 分别向左右遍历，需要回溯 count 的值和 path 的节点
        if (root.left != null) {
            path.add(root.left.val);
            traversal(root.left, count - root.left.val);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right, count - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
