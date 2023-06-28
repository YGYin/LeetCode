package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_L01 {
    List<List<Integer>> res = new ArrayList<>();

    /*
        借助队列进行 BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            // 记录当前本层的节点数量
            int qSize = que.size();
            while (qSize-- > 0) {
                TreeNode cur = que.poll();
                row.add(cur.val);
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            res.add(row);
        }
        return res;
    }
}
