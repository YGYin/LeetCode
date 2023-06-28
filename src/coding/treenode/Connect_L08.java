package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_L08 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            Node pre = null;
            Node cur;
            for (int i = 0; i < levelSize; i++) {
                if (i == 0) {
                    pre = que.poll();
                    cur = pre;
                } else {
                    cur = que.poll();
                    pre.next = cur;
                    pre = pre.next;
                }
                // 加入节点
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            pre.next = null;
        }
        return root;
    }
}
