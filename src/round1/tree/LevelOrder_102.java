package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 判空
        if (root == null)
            return res;
        // 借助队列进行层次遍历，先推入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 新建 list 来储存每一行的元素
            List<Integer> row = new ArrayList<>();
            // 每一行遍历之前获取辅助队列长度，得知该行包含元素数量
            int rowSize = queue.size();
            for (int i = 0; i < rowSize; i++) {
                // poll 出节点，存入到该行的 list 当中
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 遍历完当前层后，将该层的 list 加入到 res 中
            res.add(row);
        }

        return res;
    }
}
