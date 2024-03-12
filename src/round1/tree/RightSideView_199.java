package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        // 右视图，遍历每层的时候将最右侧加入到 list 中
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 此处可以不存每层所有的元素，所以无需新建 rowList
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                if (i == qSize - 1)
                    res.add(curNode.val);
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
        }

        return res;
    }
}
