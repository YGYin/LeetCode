package round2.tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_429 {
    /*
        N 叉树的层序遍历
        原来加入新节点的时候只需判断左右节点是否为空
        现在判断 children list 是否为空，不为空则遍历 list 看里面 child 是否为空
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node cur = queue.poll();
                list.add(cur.val);
                // 先检查 children list 是否为空
                if (cur.children == null)
                    continue;
                // 不为空再遍历，将每个不为空的 child 加入到队列中
                for (Node child : cur.children)
                    if (child != null)
                        queue.add(child);
            }
            // 遍历完当前层后，将 list 加入 res
            res.add(list);
        }
        return res;
    }
}
