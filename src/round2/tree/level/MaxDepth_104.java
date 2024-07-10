package round2.tree.level;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
    /*
        二叉树的最大深度
        1. 层序遍历
        2. 递归，后序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 记录深度
            ++depth;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return depth;
    }

    // 返回最大深度（高度），传入根节点
    public int maxDepth_2(TreeNode root) {
        if (root == null)
            return 0;

        // 左右中
        int left = maxDepth_2(root.left);
        int right = maxDepth_2(root.right);
        // 加上当前层高度
        return Math.max(left, right) + 1;
    }
}
