package round4.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_102 {
    /*
        层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 新建 list 用于储存结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        // 新建辅助队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            // 先获得当前层节点个数，新建 list 储存当前层
            int levelSize = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = deque.poll();
                list.add(cur.val);
                if (cur.left != null)
                    deque.offer(cur.left);
                if (cur.right != null)
                    deque.offer(cur.right);
            }
            // 将当前层加入到 res 中
            res.add(list);
        }

        return res;
    }
}
