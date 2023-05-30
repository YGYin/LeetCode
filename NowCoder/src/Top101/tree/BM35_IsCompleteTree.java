package Top101.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BM35_IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        // 空树一定是完全二叉树
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        boolean notComplete = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            // 标记第一次遇到空节点，代表已经到了完全二叉树的最下层
            if (cur == null) {
                notComplete = true;
                continue;
            }
            // 若遇到空节点后还有后续访问，说明经过了叶子节点
            if (notComplete)
                return false;
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return true;
    }
}
