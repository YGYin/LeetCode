package round2.tree.level;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_116 {
    /*
        填充每个节点的下一个右侧节点指针
        层序遍历
        1. 本质用双指针，每层记录下开头的首节点为 pre，非首节点时让 pre.next 指向 cur
        2. 完成当前层遍历时，pre 刚好为最右侧节点，pre.next 指向 null
     */
    public Node connect(Node root) {
        if (root == null)
            return root;
        // 新建辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 定义 pre 和 cur 指针
            Node pre = null;
            Node cur;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // 当前首个节点，记录 pre，并让当前节点也为 pre
                if (i == 0) {
                    pre = queue.poll();
                    cur = pre;
                }
                // 非首节点，让 pre.next 指向 cur，更新 pre 指针
                else {
                    cur = queue.poll();
                    pre.next = cur;
                    pre = cur;
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            // 当前层遍历完成后，pre 位于最右侧节点，让 pre.next 指向 null
            pre.next = null;
        }

        return root;
    }
}
