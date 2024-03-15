package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
    // 层序
    public int maxDepth(TreeNode root) {
        // 最大深度，层序遍历记录深度
        int depth = 0;
        if (root == null)
            return depth;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每层深度 + 1
            int qSize = queue.size();
            ++depth;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
        }

        return depth;
    }

    // 递归，求最大深度也等同于求树高度
    public int getHeight(TreeNode root) {
        // 节点为空时，高度为 0
        if (root == null)
            return 0;
        // 后序遍历，把左右孩子节点返回给父节点
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 中：取左右节点较高的高度，父节的高度点则在最高的子节点基础上 + 1
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
