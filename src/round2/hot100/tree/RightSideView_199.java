package round2.hot100.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView_199 {
    /*
        二叉树的右视图
        层序遍历，每次存当前层的最后一个元素
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        // 辅助队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取当前层元素个数
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                // 如果为当前层的最右边元素，加入 res 中
                if (i == qSize - 1)
                    res.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return res;
    }
}
