package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_L02 {
    /*
     *  思路：队列，迭代。
     *  层序遍历，再翻转数组即可。
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            // 记录该层节点数
            int qSize = que.size();
            // 储存该层的节点
            List<Integer> row = new ArrayList<>();
            while (qSize-- > 0) {
                TreeNode cur = que.poll();
                row.add(cur.val);
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            list.add(row);
        }
        // 反向遍历
        List<List<Integer>> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            res.add(list.get(i));

        return res;
    }
}
