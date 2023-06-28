package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class Connect_L07 {
    /*
        本题依然是层序遍历，只不过在单层遍历的时候记录一下本层的头部节点，
        然后在遍历的时候让前一个节点指向本节点就可以了
     */
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
                // 取出当前层的第一个头节点
                if (i == 0) {
                    pre = que.poll();
                    cur = pre;
                }
                // 将本层的前一个节点指向当前节点
                else {
                    cur = que.poll();
                    pre.next = cur;
                    pre = pre.next;
                }
                // 添加其他节点进入队列
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
            // 将本层最后一个节点指向 null
            pre.next = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
