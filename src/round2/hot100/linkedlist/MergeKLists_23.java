package round2.hot100.linkedlist;

import java.util.PriorityQueue;

public class MergeKLists_23 {
    /*
        合并 K 个升序链表
        主要思想：维护小顶堆（优先队列）
        1. 遍历 lists，将每个链表的链表头加入到小顶堆中
        2. 新建虚拟头节点和 cur 指针用于构造目标链表
        3. 遍历小顶堆，每次 poll 出一个节点，然后将当前节点其加入到目标链表中
        4. 移动 poll 出来的链表的指针，看是否为空，不为空再加入到小顶堆中
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // 新建小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        // 注意 lists 内的节点有可能为空
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);

        // 新建虚拟头节点和 cur 指针用于构造目标链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        // 遍历小顶堆
        while (!pq.isEmpty()) {
            // poll 出当前值最小的链表头节点
            ListNode node = pq.poll();
            // 加入到目标链表中
            cur.next = node;
            cur = cur.next;

            // 看该头节点下一个是否为空，不为空则重新加入到小顶堆中
            if (node.next != null)
                pq.add(node.next);
        }

        return dummyHead.next;
    }
}
