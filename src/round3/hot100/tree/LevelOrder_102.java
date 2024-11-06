package round3.hot100.tree;

import java.util.*;

public class LevelOrder_102 {
    /*
        层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 判空
        if (root == null)
            return res;

        // 新建辅助队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 遍历队列
        while (!queue.isEmpty()) {
            // 先获得当前层节点个数
            int qSize = queue.size();
            // 储存当前层节点的 list
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                // 检查左右子节点
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 将当前成节点加入到 list 中
            res.add(list);
        }

        return res;
    }
}
