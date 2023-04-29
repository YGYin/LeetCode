package Top101.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BM28_MaxDepth {
    public int maxDepth(TreeNode root) {
        // 空节点无深度
        if (root == null)
            return 0;
        // 返回子树的深度再 + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth_2(TreeNode root) {
        // 空节点无深度
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            ++depth;
        }
        return depth;
    }

}
