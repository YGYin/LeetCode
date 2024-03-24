package round1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_Sol {
    private DLLNode head;
    private DLLNode tail;
    Map<Integer, Object[]> maps;
    private int capacity;
    private int length;

    private static class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;

        public DLLNode() {
        }

        public DLLNode(int val) {
            this.val = val;
        }
    }

    public LRUCache_Sol() {
    }

    public LRUCache_Sol(int capacity) {
        // 初始化头尾节点，并连接头尾节点
        head = new DLLNode(-1);
        tail = new DLLNode(-1);
        head.next = tail;
        tail.prev = head;

        // 初始化 maps 和 capacity
        maps = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        // 1. 先判断哈希表中是否存在 key
        //  存在的话返回 key 的 val ，并将对应节点移到最前面即 head 的下一个节点
        if (maps.containsKey(key)) {
            // 1.1 先从哈希表中获取节点
            DLLNode curNode = (DLLNode) maps.get(key)[0];
            // 记录该节点的前节点和后节点
            // 将两者连接起来，等价于在双向链表中删除 curNode
            deleteNode(curNode);

            // 1.2 将其插入到头节点后，需先记录头节点的后节点
            // 连接上头节点和 curNode 以及 temp
            moveToHead(curNode);
            return (int) maps.get(key)[1];
        }
        // key 不存在 maps 中
        return -1;

    }

    public void put(int key, int value) {
        // 判断哈希表中是否存储了 key
        // 如果存在，不仅需要返回 key 的 value，还需将其移动到 head 后面
        if (maps.containsKey(key)) {
            // 获取节点
            DLLNode curNode = (DLLNode) maps.get(key)[0];
            // 记录前后节点，连接起来删除 curNode
            deleteNode(curNode);

            moveToHead(curNode);
            // 更新节点的值
            maps.put(key, new Object[]{curNode, value});
            return;
        }

        // 如果不包含该 key，先判断缓存容量是否满了
        // 满了删除最后一个节点
        if (length == capacity) {
            DLLNode delNode = tail.prev;
            deleteNode(delNode);
            // 哈希表移除该节点的值 ！
            maps.remove(delNode.val);
            --length;
        }
        // 然后再将添加的节点移动到前面去
        DLLNode curNode = new DLLNode(key);
        moveToHead(curNode);
        // 添加到哈希表中
        maps.put(key, new Object[]{curNode, value});
        ++length;
        return;
    }

    private void moveToHead(DLLNode curNode) {
        // 记录头节点下一节点
        DLLNode temp = head.next;
        // 连接 head temp curNode
        head.next = curNode;
        curNode.prev = head;
        curNode.next = temp;
        temp.prev = curNode;
    }

    private void deleteNode(DLLNode curNode) {
        DLLNode prevNode = curNode.prev;
        DLLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

