package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum_11 {
    /*
        DFS
        要遍历整个树，找到所有路径，所以递归函数不要返回值
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new LinkedList<>();
        traversal(root, targetSum, res, path);
        return res;
    }

    private void traversal(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        // 将当前节点加入 path
        path.add(root.val);
        // 结束条件：到达叶子节点且 targetSum 为 0
        // 如果遇到叶子节点
        if (root.left == null && root.right == null) {
            // 而且和还为 target
            if (targetSum - root.val == 0)
                res.add(new ArrayList<>(path));
            // 和不为 target 则返回
            return;
        }
        // 因为终止条件是判断叶子节点，所以递归的过程中不要让空节点进入递归
        // 左
        if (root.left != null) {
            // 向左遍历且 targetSum 回溯
            traversal(root.left, targetSum - root.val, res, path);
            // 记录的 path 回溯
            path.remove(path.size() - 1);
        }
        // 右
        if (root.right != null) {
            traversal(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}
