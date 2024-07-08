package round2.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 定义辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取当前层的节点个数
            int levelSize = queue.size();
            // 定义 list 用于储存当前层节点
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 将当前行的 list 加入到 res 中
            res.add(list);
        }
        return res;
    }
}
