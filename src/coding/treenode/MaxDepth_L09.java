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
}
