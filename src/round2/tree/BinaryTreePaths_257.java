package round2.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    List<String> res = new ArrayList<>();
    // 记录路径的节点的值
    List<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        // 加入首个节点
        path.add(root.val);
        traversal(root);
        return res;
    }

    // 1. 传入当前节点（path 和 res 记录当前路径和所有路径）
    private void traversal(TreeNode root) {
        // 到达叶子节点，收获结果
        if (root.left == null && root.right == null) {
            // 遍历 path，用 StringBuilder 拼接每一个节点的值
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                // 到最后一个节点，只用加上节点
                if (i == path.size() - 1) {
                    builder.append(path.get(i));
                    break;
                }
                builder.append(path.get(i)).append("->");
            }
            // 将当前路径加入到 res 中
            res.add(builder.toString());
        }

        // 左右
        // 需要先判断左右是否为空
        if (root.left != null) {
            path.add(root.left.val);
            // 因为传入的节点会被加入到 path 中
            traversal(root.left);
            // 需要回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            traversal(root.right);
            path.remove(path.size() - 1);
        }
    }
}
