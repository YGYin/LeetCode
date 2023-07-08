package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue_09 {
    /*
        1. 层序遍历，记录最后一层的第一个节点
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int res = 0;
        while (!que.isEmpty()) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                if (i == 0)
                    res = cur.val;
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
        }
        return res;
    }

    /*
        2. 递归，前序遍历
        记录叶子节点当前最大深度的值，向左向右一边遍历一边回溯
        记录深度为关键，只会记录当前最深深度的第一个节点
     */
    private int maxDepth = -1;
    private int res = 0;

    public int findBottomLeftValue_2(TreeNode root) {
        res = root.val;
        findLeftVal(root, 0);
        return res;
    }

    private void findLeftVal(TreeNode root, int depth) {
        // 结束条件
        if (root == null)
            return;
        // 中
        if (root.left == null && root.right == null) {
            // 如果当前节点深度超过之前的节点
            // 更新 res 和最大深度
            if (depth > maxDepth) {
                res = root.val;
                maxDepth = depth;
            }
        }
        // 左
        if (root.left != null) {
            ++depth;
            findLeftVal(root.left, depth);
            --depth; // 回溯
        }
        // 右
        if (root.right != null) {
            ++depth;
            findLeftVal(root.right, depth);
            --depth; // 回溯
        }
    }
}
