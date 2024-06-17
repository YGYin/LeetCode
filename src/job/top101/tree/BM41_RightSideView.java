package job.top101.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BM41_RightSideView {
    /*
        二叉树的右视图
        1. 层序遍历
        2. 每层到达当前 size 的最后一个节点时添加到 list 中
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        // 定义辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 先获取当前层节点个数
            int qSize = queue.size();
            // 遍历当前层
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                // 如果为最右边元素则加入到 list 中
                if (i == qSize - 1)
                    list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return list;
    }
}
