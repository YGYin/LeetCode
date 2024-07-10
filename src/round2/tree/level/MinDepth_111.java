package round2.tree.level;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_111 {
    /*
        二叉树的最小深度
        1. 层序遍历，遇到左右子节点为空则返回深度
        2. 递归
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 统计深度
            ++depth;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (cur.left == null && cur.right == null)
                    return depth;
            }
        }
        return depth;
    }

    // 递归，后序遍历，传入根节点，返回最小深度
    public int minDepth_2(TreeNode root) {
        // 当前节点为空的深度为 0
        if (root == null)
            return 0;

        int left = minDepth_2(root.left);
        int right = minDepth_2(root.right);
        // 相比于求最大高度需要注意 中 的处理逻辑
        // 因为遍历到叶子节点左右都为空时，才时最小深度
        // 需要处理单一边孩子为空的时候，则取另外一边的深度 + 1
        if (root.left == null && root.right != null)
            return right + 1;
        if (root.left != null && root.right == null)
            return left + 1;
        // 左右都不为空，则取较小的 + 1
        return Math.min(left, right) + 1;
    }
}
