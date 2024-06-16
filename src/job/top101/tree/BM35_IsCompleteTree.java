package job.top101.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BM35_IsCompleteTree {
    /*
        判断是不是完全二叉树
        明确完全二叉树定义，叶子节点只能出现在最下层或者次下层
        使用层序遍历，如果其他层出现叶子节点说明不是完全二叉树
        1. 空树为完全二叉树
        2. 层序遍历过程中，遇到了第一个空节点进行标记，代表已经到了完全二叉树的最底层
            如果后续还有节点访问，则说明提前出现了叶子节点，不符合完全二叉树的性质
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean meetNull = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 遇到首个或后续空节点时做标记，后续应该都为空
            if (cur == null) {
                meetNull = true;
                continue;
            }
            // 已经遇到过空节点后还有后续节点的话则不符合完全二叉树性质
            if (meetNull)
                return false;
            // 无论空节点还是非空节点都加入到队列中
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
