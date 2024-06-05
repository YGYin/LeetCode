package job.top101.linkedlist;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BM5_MergeKLists {
    /*
        合并 k 个升序链表
        构建小顶堆，把每个链表的头节点加入到小顶堆里
        每次 poll 一个，poll 完移动 cur 和链表指针
        如果那条链表不为空，则将新的节点加入到小顶堆中
        o1 - o2: 小顶堆
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty())
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        // 将 lists 里面的所有链表头加入到小顶堆中
        for (int i = 0; i < lists.size(); i++) {
            // 里面可能有空链表，需判断
            ListNode head = lists.get(i);
            if (head != null)
                pq.add(head);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 当队列不为空时 poll 队列
        while (!pq.isEmpty()) {
            // cur 指向小顶堆 poll 出来的节点
            ListNode node = pq.poll();
            cur.next = node;
            // 更新指针，如果 node 不为空则重新加入小顶堆
            cur = cur.next;
            node = node.next;
            if (node != null)
                pq.add(node);
        }

        return dummyHead.next;
    }
}
