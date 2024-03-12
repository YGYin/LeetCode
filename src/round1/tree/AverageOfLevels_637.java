package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录每层的和
            double sum = 0;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                ;
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
            // 计算每层的平均值
            double rowAvg = sum / qSize;
            res.add(rowAvg);
        }

        return res;
    }
}
