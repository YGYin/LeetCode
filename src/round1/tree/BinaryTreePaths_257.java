package round1.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        // 求所有路径，前序遍历可以让父节点指向子节点以得到路径
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    // 1. 确定返回值为空，参数需要传入节点，
    //    传入 List 记录单条路径，还有另外一个 List 记录所有路径
    private void traversal(TreeNode node, List<Integer> path, List<String> res) {
        // 中：处理逻辑把遍历到的节点加入到 path 当中
        path.add(node.val);

        // 2. 终止条件，记录路径不需要遍历到空节点
        //    遇到叶子节点结束遍历，收获结果
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++)
                sb.append(path.get(i)).append("->");
            // 加上 path 中最后一个节点
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            // 完成收获，返回
            return;
        }

        // 左，需要判断该方向不为空再遍历
        if (node.left != null) {
            // 递归后就是回溯
            traversal(node.left, path, res);
            // pop back 当前刚加入的元素
            path.remove(path.size() - 1);
        }
        // 右
        if (node.right != null) {
            traversal(node.right, path, res);
            //pop back
            path.remove(path.size() - 1);
        }
    }
}
