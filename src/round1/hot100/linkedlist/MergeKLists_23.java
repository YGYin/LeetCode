package round1.hot100.linkedlist;

import java.util.PriorityQueue;

public class MergeKLists_23 {
    // 定义优先队列（类似小顶堆
    PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);

    public ListNode mergeKLists(ListNode[] lists) {
        // 合并 k 个升序链表
        // 将 lists 中每个升序链表的首节点加入到优先队列
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);

        // 再定义虚拟头节点和指针用于构建链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 遍历优先队列，先从队列中 poll 一个 node 出来，加入到新链表中
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            // 然后看 node 下一位是否为空，不为空就在该链表上后移一位后再加入到优先队列中
            node = node.next;
            if (node != null)
                pq.add(node);
        }
        return dummyHead.next;
    }

}
