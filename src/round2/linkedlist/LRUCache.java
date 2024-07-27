package round2.linkedlist;


// 需要定义双向链表节点 DLNode

import java.util.HashMap;
import java.util.Map;

class DLNode {
    int val;
    DLNode prev;
    DLNode next;

    public DLNode() {
    }

    public DLNode(int val) {
        this.val = val;
    }
}

public class LRUCache {
    // 定义头尾节点
    DLNode head;
    DLNode tail;

    // 定义最大容量和当前大小
    int capacity;
    int size;
    // 定义 map，val 为 Object[DLNode, val]
    Map<Integer, Object[]> map;

    public LRUCache(int capacity) {
        // 初始化头尾节点，连接头尾节点
        head = new DLNode(-1);
        tail = new DLNode(-1);
        head.next = tail;
        tail.prev = head;

        // 初始化容量和当前 size 以及 map
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    // 获取节点
    public int get(int key) {
        // 如果 map 中存在节点
        if (map.containsKey(key)) {
            // 先获取对应节点，将节点移动到双向链表的头部
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // 再返回对应的 val
            return (int) map.get(key)[1];
        }
        return -1;
    }

    public void put(int key, int value) {
        // 先检查是否存在，存在则移动到头部并更新 val
        if (map.containsKey(key)) {
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // 更新 val
            map.put(key, new Object[]{curNode, value});
            return;
        }
        // 不存在则需要 put 新节点进 map，先检查容量是否已满
        if (size == capacity) {
            // 删除双向链表中最后一个节点
            DLNode delNode = tail.prev;
            removeNode(delNode);
            map.remove(delNode.val);
            --size;
        }
        // 新建节点进链表，并且在 map 中建立联系
        DLNode newNode = new DLNode(key);
        moveNodeToHead(newNode);
        map.put(key, new Object[]{newNode, value});
        return;
    }

    // 将当前节点移动到头部
    private void moveNodeToHead(DLNode curNode) {
        DLNode nextNode = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = nextNode;
        nextNode.prev = curNode;
    }

    // 移除当前节点，直接将前一节点连接到下一节点
    private void removeNode(DLNode curNode) {
        DLNode prevNode = curNode.prev;
        DLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


}
