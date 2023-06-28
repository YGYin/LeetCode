package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_L04 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add((double) root.val);
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int qSize = que.size();
            double levelSum = 0.0;
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = que.poll();
                levelSum += cur.val;
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            res.add(levelSum / qSize);
        }
        return res;
    }
}
