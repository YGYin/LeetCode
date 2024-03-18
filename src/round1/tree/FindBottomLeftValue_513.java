package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                // 记录将每行的第一个节点
                if (i == 0)
                    res = curNode.val;
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
        }
        return res;
    }
}
