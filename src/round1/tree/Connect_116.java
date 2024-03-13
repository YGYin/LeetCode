package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_116 {
    public Node connect(Node root) {
        // 主要每层遍历的时候记录下本层的头部节点
        // 遍历的时候让前一个节点指向本节点
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 定义双指针
            Node pre = null;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node cur = queue.poll();
                // 如果是头节点，pre 和 cur 指向同一个顶点
                if (i == 0)
                    pre = cur;
                else {
                    // 非头节点
                    pre.next = cur;
                    // 更新 pre 指针
                    pre = pre.next;
                }
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            pre.next = null;
        }

        return root;
    }

}
