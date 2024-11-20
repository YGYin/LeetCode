package round3.hot100.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView_199 {
    /*
        二叉树的右视图
        层序遍历，取每层最后一个
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 判空
        if (root == null)
            return res;

        // 辅助队列，加入根节点
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 先取当前行的元素个数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // 取出节点
                TreeNode cur = queue.poll();
                // 如果是最右侧的节点则加入 res
                if (i == levelSize - 1)
                    res.add(cur.val);
                // 左右节点不为空则将子节点加入到队列中
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return res;
    }
}
