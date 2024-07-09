package round2.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {
    /*
        二叉树的层平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0.0d;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                sum += (double) cur.val;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 当前层遍历完后计算平均值加入 res 中
            res.add((Double) sum / levelSize);
        }

        return res;
    }
}
