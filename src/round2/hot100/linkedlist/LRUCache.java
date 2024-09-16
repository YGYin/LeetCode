package round2.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
    LRU 缓存
    需要定义双向链表节点，包括 val(key) prev next
    LRU 需要头尾节点，capacity 和 size
        同时需要维护一个 map，
        key: 传入的 key  val: Object[]{DLNode, 传入的 value}
 */
class DLNode {
    int val;
    DLNode prev;
    DLNode next;

    public DLNode(int val) {
        this.val = val;
    }
}

public class LRUCache {
    // 头尾节点，capacity，size，map
    DLNode head;
    DLNode tail;
    int capacity;
    int size;
    // key: 传入的 key(也就是 DLNode.val)
    // val: Object[]{DLNode, 实际传入的 val}
    Map<Integer, Object[]> map;

    public LRUCache(int capacity) {
        // 初始化
        head = new DLNode(-1);
        tail = new DLNode(-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
    }

    // 获取节点
    public int get(int key) {
        // 检查 map 中是否存在，存在就移动到队列最前
        if (map.containsKey(key)) {
            // 取出该节点并将其移到头部
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // 返回 map 中储存的 value
            return (int) map.get(key)[1];
        }
        return -1;
    }

    // 插入节点
    public void put(int key, int value) {
        // 先检查当前 map 中是否存在这个节点
        if (map.containsKey(key)) {
            // 存在的话移动到头部
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // put 新的 value 需要更新 map 中的 value
            map.put(key, new Object[]{curNode, value});
            return;
        }
        // 如果不存在这个节点，需要检查 map 中容量是否已经满了
        if (size == capacity) {
            // 删除尾部的前一个节点
            DLNode delNode = tail.prev;
            removeNode(delNode);
            // 删除 map 中对应的这个节点
            map.remove(delNode.val);
            --size;
        }
        // 再加入新的节点到头部
        DLNode newNode = new DLNode(key);
        moveNodeToHead(newNode);

        // map 中加入对应节点和 val
        map.put(key, new Object[]{newNode, value});
        ++size;
    }

    private void moveNodeToHead(DLNode curNode) {
        DLNode nextNode = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = nextNode;
        nextNode.prev = curNode;
    }

    private void removeNode(DLNode curNode) {
        DLNode prevNode = curNode.prev;
        DLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}