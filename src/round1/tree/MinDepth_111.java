package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
        // 与最大深度逻辑相同，只是加多一个判断子节点的逻辑
        int depth = 0;
        if (root == null)
            return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 与最大深度题目统一逻辑，在 for 前 depth ++
            int qSize = queue.size();
            ++depth;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
                if (curNode.left == null && curNode.right == null)
                    return depth;
            }
        }

        return depth;
    }
}
