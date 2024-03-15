package round1.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_117 {
    public Node connect(Node root) {
        if (root == null)
            return root;

        // 辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // 新建指针
        Node curNode, pre = null;
        while (!queue.isEmpty()) {

            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                curNode = queue.poll();
                if (i == 0)
                    pre = curNode;
                else {
                    pre.next = curNode;
                    pre = pre.next;
                }
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);

                pre.next = null;
            }
        }
        return root;
    }
}
