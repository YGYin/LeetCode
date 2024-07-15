package round2.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue_513 {
    /*
        找树左下角的值
        层序遍历，取每层的第一个，每层遍历的时候更新
     */
    public int findBottomLeftValue(TreeNode root) {
        // 因为假设二叉树至少有一个节点，可不判空
        if (root == null)
            return 0;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 记录每层的第一个节点
        int res = 0;
        while (!queue.isEmpty()) {
            // 取当前层节点数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                // 当前层的第一节点
                if (i == 0)
                    res = cur.val;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return res;
    }
}
