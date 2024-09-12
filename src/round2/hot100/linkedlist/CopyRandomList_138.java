package round2.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_138 {
    /*
        随机链表的复制
        利用 map 来储存新旧链表一一对应的关系，
            key: 原来链表节点  val: 新链表节点
        1. 第一遍遍历原链表，复制值创建新节点到 map 中
        2. 第二遍遍历原链表，根据原链表的 next 和 random 在 map 中查
            并为 map 中对应节点设置对应的 next 和 random
     */
    public Node copyRandomList(Node head) {
        if (head == null || head.next == null)
            return head;
        // 创建 map 来储存复制的链表
        // key: 原来链表节点  val: 新链表节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 第二次遍历，为 map 中新链表的节点设置 next 和 random
        cur = head;
        while (cur != null) {
            // 先从 map 中获取当前节点对应的新链表节点
            Node newNode = map.get(cur);
            // 给新链表节点设定对应的 next 和 random
            // 需要先判断当前旧链表节点的 next 和 random 是否为空
            if (cur.next != null)
                newNode.next = map.get(cur.next);
            if (cur.random != null)
                newNode.random = map.get(cur.random);

            cur = cur.next;
        }
        // 返回新链表的对应头部
        return map.get(head);
    }
}
