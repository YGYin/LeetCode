package round2.hot100.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder_102 {
    /*
        层序遍历
        通过辅助队列实现
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 判空
        if (root == null)
            return res;

        // 新建辅助队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 先获取当前队列(层)的个数
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            // 遍历当前层
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 遍历完当前层之后加当前 list 加入到 resList 中
            res.add(list);
        }

        return res;
    }
}
