package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取当前层元素个数
            // 初始化 levelMax 记录每层最大值
            int qSize = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                levelMax = Math.max(levelMax, curNode.val);
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
            // 将当前层最大值加入到 res 中
            res.add(levelMax);
        }

        return res;
    }
}
