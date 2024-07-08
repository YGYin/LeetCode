package round2.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 和层序遍历基本相同，最后再开一个 res list 来倒序储存
        List<List<Integer>> tempRes = new ArrayList<>();
        if (root == null)
            return tempRes;
        // 新建辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 新建 list 储存当前层节点
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            tempRes.add(list);
        }

        // 新建 res list 来倒序储存
        List<List<Integer>> res = new ArrayList<>();
        for (int i = tempRes.size() - 1; i >= 0; i--)
            res.add(tempRes.get(i));

        return res;
    }
}
