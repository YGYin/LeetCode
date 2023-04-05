package Top101.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BM12_SortInList {

    /*
        终止条件: 当子链表划分到为空或者只剩一个节点时，不再继续划分，往上合并
        返回值: 每次返回两个排好序且合并好的子链表
        本级任务: 找到这个链表的中间节点，从前面断开，分为左右两个子链表，进入子问题排序
        1. 首先判断链表为空或者只有一个元素，直接就是有序的
        2. 准备三个指针，快指针right每次走两步，慢指针mid每次走一步，
           前序指针left每次跟在mid前一个位置。三个指针遍历链表，
           当快指针到达链表尾部的时候，慢指针mid刚好走了链表的一半，正好是中间位置
        3. 从left位置将链表断开，刚好分成两个子问题开始递归
        4. 将子问题得到的链表合并，参考合并两个有序链表

        时间复杂度: O(nlogn)，每级最坏需要遍历全部元素为 O(n)
                   每级合并都是将同级值问题链表合并，也为 O(n)
                   分治为二叉树，一共有 O(logn)层
        空间复杂度: O(logn)，递归栈的深度最坏为树型递归的深度
     */
    public ListNode sortInList(ListNode head) {
        // 链表为空或者只有一个元素，则其为有序
        if (head == null || head.next == null)
            return head;
        ListNode slowP = head;
        ListNode midP = head.next;
        ListNode fastP = head.next.next;
        // 快指针到达链表末尾时，中间指针刚好指向该链表中间
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            midP = midP.next;
            fastP = fastP.next.next;
        }
        // 从慢指针处断开
        slowP.next = null;
        // 分成两段排序，合并排序好的两段
        return mergeTwoList(sortInList(head), sortInList(midP));
    }

    ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return res.next;
    }

    public ListNode sortInList_2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode ptr = head;
        // 先遍历一次链表，将节点数值加入数组
        while (ptr != null) {
            nums.add(ptr.val);
            ptr = ptr.next;
        }
        // 重新排序
        Collections.sort(nums);
        // 重新指向头部
        ptr = head;
        for (int i = 0; i < nums.size(); ++i) {
            // 遍历数组，将元素一次再加入链表
            ptr.val = nums.get(i);
            ptr = ptr.next;
        }
        return head;
    }
}
