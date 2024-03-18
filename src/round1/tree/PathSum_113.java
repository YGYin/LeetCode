package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 路径总和I 只需要找到一条路径
        // 路径总和II 需要找到所有路径，所以递归函数不需要返回值
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new LinkedList<>();
        // 1. 无需返回值，传入根节点，目标和，path 和 res
        preorder(root, targetSum, path, res);
        return res;
    }

    private void preorder(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        // 每次都先添加当前节点
        path.add(root.val);
        // 如果为叶节点，再判断 targetSum 减去当前是否为 0，是的话添加到 res 中
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0)
                res.add(new ArrayList<>(path));
            // 如果当前完整路径不为 target 则返回
            return;
        }
        if (root.left != null) {
            // 每次不仅对 targetSum 进行操作，还对 path 增加了节点
            preorder(root.left, targetSum - root.val, path, res);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preorder(root.right, targetSum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}
