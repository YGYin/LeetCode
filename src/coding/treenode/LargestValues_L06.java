package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues_L06 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
