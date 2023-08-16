package coding.treenode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_07 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        // 用于记录结果中的路径
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        // 采用前序遍历，一边遍历一边回溯
        paths.add(root.val); // 中
        // 遇到叶子节点，遍历 paths 中的节点
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++)
                sb.append(paths.get(i)).append("->");
            // 记录最后一个节点
            sb.append(paths.get(paths.size() - 1));
            // 收集当前路径到 res 中
            res.add(sb.toString());
            return;
        }
        // 左，因为递归和回溯同时进行，要放在同一个花括号里
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
