package round1.hot100.linkedlist;


import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_138 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // 用哈希表解决问题，利用新旧链表在 map 中一一对应的关系
        // 首先创建哈希表，key: 原链表的节点  value: 新链表的节点
        Map<Node, Node> map = new HashMap<>();
        // 遍历原来的链表，遍历的时候创建新节点放入哈希表中
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 然后再遍历原链表，根据原链表将新链表的 next 和 random 设置上
        cur = head;
        while (cur != null) {
            // map.get(原节点)，得到的就是对应的新节点
            Node node = map.get(cur);
            // map.get(原节点.next)，得到的就是对应的新节点.next
            if (cur.next != null)
                node.next = map.get(cur.next);
            // map.get(原节点.random)，得到的就是对应的新节点.random
            if (cur.random != null)
                node.random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }
}
