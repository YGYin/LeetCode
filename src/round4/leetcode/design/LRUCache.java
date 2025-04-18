package round4.leetcode.design;

import java.util.HashMap;
import java.util.Map;

class DLNode {
    // 双向链表，储存 key 和 value
    DLNode prev;
    DLNode next;
    int key;
    int value;

    public DLNode() {
    }

    public DLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    // 需要头尾节点，容量，当前大小以及 map
    DLNode head;
    DLNode tail;
    int capacity;
    int size;
    // key: key  val: DLNode(key, value)
    Map<Integer, DLNode> map;

    public LRUCache(int capacity) {
        // 初始化容量，size， map 和 头尾节点
        this.capacity = capacity;
        this.size = 0;
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    // 如果存在，获取节点，并将节点移动到头部，否则返回 -1
    public int get(int key) {
        if (map.containsKey(key)) {
            DLNode curNode = map.get(key);
            removeNode(curNode);
            addNodeToHead(curNode);
            return curNode.value;
        }
        return -1;
    }

    // 看是否存在，存在就取出来更新 value，移动到头部
    // 不存在，先看容量是否已满，满了就移除尾部节点，再加入新节点
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode curNode = map.get(key);
            curNode.value = value;
            removeNode(curNode);
            addNodeToHead(curNode);
            map.put(key, curNode);
            return;
        }
        // 看是否已满，满了需要先移除尾部节点，删除 map 对应 k-v
        if (size == capacity) {
            DLNode delNode = tail.prev;
            removeNode(delNode);
            map.remove(delNode.key);
            --size;
        }
        // 新建节点加入到双向链表和 map 中
        DLNode newNode = new DLNode(key, value);
        addNodeToHead(newNode);
        map.put(key, newNode);
        ++size;
    }

    private void addNodeToHead(DLNode curNode) {
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
