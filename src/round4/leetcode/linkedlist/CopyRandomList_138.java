package round4.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_138 {
    /*
        随机链表的复制
        利用 map 来储存新旧链表一一对应的关系，
            key: 原来链表节点  val: 新链表节点
        1. 第一遍遍历原链表，复制值创建新节点到 map 中
        2. 第二遍遍历原链表，给新节点赋予 next 和 random
            根据原链表的 next 和 random 在 map 中查新节点对应的 next 和 random
            并为 map 中对应节点设置对应的 next 和 random
        3. 返回 map.get(head) 为新头节点
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // map 储存原链表和新链表节点的对应关系
        Map<Node, Node> map = new HashMap<>();
        // 第一遍遍历原链表，复制值创建新节点到 map 中
        Node cur = head;
        while (cur != null) {
            // key: 原来链表节点  val: 新链表节点
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 重新指向头部，第二遍遍历原链表，给新节点赋予 next 和 random
        cur = head;
        while (cur != null) {
            // 获取当前节点对应的新链表节点
            Node newNode = map.get(cur);
            // 如果不为空，根据原链表的 next 和 random 在 map 中查新节点对应的 next 和 random
            if (cur.next != null)
                newNode.next = map.get(cur.next);
            if (cur.random != null)
                newNode.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
