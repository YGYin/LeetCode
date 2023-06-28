package coding.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_L05 {
    /*
        流程基本一致，判空，将根节点加入辅助队列，开始遍历，
        只是在加入子节点时，需要遍历 curNode 里面的 children node 数组
     */
    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node1> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node1 cur = que.poll();
                levelList.add(cur.val);
                // 加入子节点需要遍历其 children 数组
                List<Node1> children = cur.children;
                if (children == null || children.size() == 0)
                    continue;
                for (Node1 child : children)
                    que.offer(child);
            }
            res.add(levelList);
        }
        return res;
    }
}
