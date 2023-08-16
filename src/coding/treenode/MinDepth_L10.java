package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_L10 {
    // 1. BFS，层序遍历
    public int minDepth(TreeNode root) {
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
                // 只有左右孩子都为空的时候才说明遍历到最低点了
                if (cur.left == null && cur.right == null)
                    return depth;
            }
        }
        return depth;
    }

    /*
        2. DFS，递归，后序遍历
     */
    public int minDepth_rec(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        // 左
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        // 此处不能直接写 return 1 + min(left, right)
        // 需要考虑左节点单独为空或者右节点单独为空的情况
        if (root.left == null && root.right != null)
            return 1 + rightDepth;
        if (root.left != null && root.right == null)
            return 1 + leftDepth;
        // 两个同时不为空才取左右高度偏小值
        return 1 + Math.min(leftDepth, rightDepth);
    }

}
