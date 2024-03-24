package round1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int length;
    int capacity;
    Map<Integer, Object[]> maps;
    DLLNode head;
    DLLNode tail;

    public LRUCache(int capacity) {
        // 初始化 head 和 tails，并连接
        head = new DLLNode(-1);
        tail = new DLLNode(-1);
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
        maps = new HashMap<>();
    }

    public int get(int key) {
        // 如果在缓存中
        if (maps.containsKey(key)) {
            // 获取当前节点，然后将该节点先断开连接再移动到头部
            DLLNode curNode = (DLLNode) maps.get(key)[0];
            deleteNode(curNode);
            moveToHead(curNode);
            return (int) maps.get(key)[1];
        }
        return -1;
    }

    private void moveToHead(DLLNode curNode) {
        DLLNode temp = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = temp;
        temp.prev = curNode;
    }

    private void deleteNode(DLLNode curNode) {
        DLLNode prev = curNode.prev;
        DLLNode next = curNode.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        // 先检查有没有
        // 存在的话，移动到头部，然后更新值
        if (maps.containsKey(key)) {
            DLLNode curNode = (DLLNode) maps.get(key)[0];
            deleteNode(curNode);
            moveToHead(curNode);
            maps.put(key, new Object[]{curNode, value});
            return;
        }
        // 不存在就要新加节点，需要看缓存是否满了，满了的话先删除末尾
        if (length == capacity) {
            // 满了删除末尾节点，删除 maps 中映射关系
            DLLNode delNode = tail.prev;
            deleteNode(delNode);
            maps.remove(delNode.val);
            length--;
        }
        // 加入新节点到头部
        DLLNode node = new DLLNode(key);
        moveToHead(node);
        maps.put(key, new Object[]{node, value});
        length++;
    }

    private class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;

        public DLLNode() {
        }

        public DLLNode(int val) {
            this.val = val;
        }
    }
}
