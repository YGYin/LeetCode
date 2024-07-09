package round2.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues_515 {
    /*
        在每个树行中找最大值
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 判空
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 用于记录当前行最大值
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                maxVal = Math.max(maxVal, cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 将当前行最大值加入到 res
            res.add(maxVal);
        }

        return res;
    }
}
