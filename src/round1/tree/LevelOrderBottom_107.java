package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 与层序遍历思路相同，最后再反转 list 即可
        List<List<Integer>> tempRes = new ArrayList<>();
        if (root == null)
            return tempRes;
        // 辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 新建 list 储存当前层的元素
            List<Integer> row = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                row.add(curNode.val);
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
            // 加入到 res 中
            tempRes.add(row);
        }
        // 需要自底向上的层序遍历，反转 tempRes
        // list 可直接用 get(index)
        List<List<Integer>> res = new ArrayList<>();
        for (int i = tempRes.size() - 1; i >= 0; i--)
            res.add(tempRes.get(i));

        return res;
    }
}
