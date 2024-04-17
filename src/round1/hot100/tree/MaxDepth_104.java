package round1.hot100.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        // 层序遍历，每层深度加一
        int depth = 0;
        if (root == null)
            return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取当前层长度
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                // 取出节点，将其左右节点加入到队列中
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 当前层遍历结束，更新深度
            ++depth;
        }
        return depth;
    }
}
