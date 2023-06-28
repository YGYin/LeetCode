package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_L03 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int qSize = que.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = que.poll();
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
                // 到达最右端节点储存到 res 列表中
                if (i == qSize - 1)
                    res.add(cur.val);
            }
        }
        return res;
    }
}
