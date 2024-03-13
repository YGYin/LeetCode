package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
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
}
