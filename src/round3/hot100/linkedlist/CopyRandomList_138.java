package round3.hot100.linkedlist;

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
        if (head == null)
            return null;

        // 用 map 来储存新旧链表一一对应的关系
        // key: 原来链表节点  val: 新链表节点
        Map<Node, Node> map = new HashMap<>();
        // 第一遍遍历原链表，复制其值新建节点放入 map 中
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 重新指向头部，第二次遍历给新节点赋予 next 和 random
        cur = head;
        while (cur != null) {
            // 先从 map 中取出对应的新节点
            Node newNode = map.get(cur);
            // 需判断是否为空，不为空则赋值
            // 注意不能直接让 newNode.next 指向旧链表的节点 cur.next
            // 而是指向对应的新链表节点 map.get(cur.next)
            if (cur.next != null)
                newNode.next = map.get(cur.next);
            if (cur.random != null)
                newNode.random = map.get(cur.random);
            // 移动指针
            cur = cur.next;
        }
        // 返回对应新链表的头部节点
        return map.get(head);
    }
}
