package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_L09 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            ++depth;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
        }
        return depth;
    }

    /*
        2. 递归，后序遍历，实际为求高度，刚好等于深度
     */
    public int maxDepth_rec(TreeNode root) {
        return getDepth(root);
    }

    // 1. 确定方法的返回值和参数
    private int getDepth(TreeNode root) {
        // 2. 确定递归结束条件，节点为空时返回 0
        if (root == null)
            return 0;
        // 左
        int leftDepth = getDepth(root.left);
        // 右
        int rightDepth = getDepth(root.right);
        // 中，处理逻辑
        return 1 + Math.max(leftDepth, rightDepth);
        // return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
