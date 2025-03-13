package round4.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

// 定义双向链表节点，包含 key 和 val
class DLNode {
    int key;
    int value;
    DLNode prev;
    DLNode next;

    public DLNode() {
    }

    public DLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    // 需要定义头尾节点，容量，当前 size，还有一个 map 储存 key 及对应的链表节点
    DLNode head;
    DLNode tail;
    int size;
    int capacity;
    // key: key  val: DLNode(key, value)
    Map<Integer, DLNode> map;

    // 构造器应该提供缓存容量大小，初始化头尾节点完成连接
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }


    /*
        如果存在 key 对应节点，将其移动到链表头部，同时返回值，否则返回 -1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            DLNode curNode = map.get(key);
            removeNode(curNode);
            moveNodeToHead(curNode);
            // 返回 value
            return curNode.value;
        }
        return -1;
    }

    /*
        1. 先检查当前节点是否存在，存在的话移动到头部，更新 value，更新 map
        2. 如果不存在，先检查容量是否已经满了
            - 已满，删除末尾的节点，移除 map 中的 k-v，--size，然后再加入节点
            - 未满直接加入节点，更新 map 和 ++size
     */
    public void put(int key, int value) {
        // 先检查当前节点是否存在，存在的话移动到头部，更新 value 和 map
        if (map.containsKey(key)) {
            DLNode curNode = map.get(key);
            removeNode(curNode);
            moveNodeToHead(curNode);
            curNode.value = value;
            map.put(key, curNode);
            return;
        }
        // 如果不存在，先检查容量是否已经满了
        if (size == capacity) {
            // 已满，删除末尾的节点
            DLNode delNode = tail.prev;
            removeNode(delNode);
            map.remove(delNode.key);
            --size;
        }
        // 新建节点加入到链表头中，同时更新 map，size
        DLNode newNode = new DLNode(key, value);
        moveNodeToHead(newNode);
        map.put(key, newNode);
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