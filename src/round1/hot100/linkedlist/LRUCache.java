package round1.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

// 定义双向链表
class Node {
    int val;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

public class LRUCache {
    // 定义头尾节点，哈希表，容量和当前 size
    Node head;
    Node tail;
    int capacity;
    int size;
    // Key: key  Val: {Node, value}
    Map<Integer, Object[]> map;

    public LRUCache(int capacity) {
        // 初始化变量
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        // 连接头尾节点
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        // 先查 map 中是否存在
        if (map.containsKey(key)) {
            // 若存在则将其先获取该 val 中的节点
            Node curNode = (Node) map.get(key)[0];
            // 先断开当前节点连接，然后再将节点移动到双向链表 head 后一位
            removeNode(curNode);
            moveToHead(curNode);
            // 再返回 val 中的 value
            return (Integer) map.get(key)[1];
        }
        return -1;
    }

    public void put(int key, int value) {
        // 先检查 map 中有没有，有的话需要更新
        if (map.containsKey(key)) {
            Node curNode = (Node) map.get(key)[0];
            // 因为访问了该节点，需要将其断开连接，移动到头部
            removeNode(curNode);
            moveToHead(curNode);
            // 更新 map 中的值
            map.put(key, new Object[]{curNode, value});
            // 记得返回
            return;
        }
        // 如果不存在，先检查容量是否已满
        if (size == capacity) {
            Node delNode = tail.prev;
            // 容量满了需要删除 tail 尾部前一个节点
            removeNode(delNode);
            // 同时更新 size 和哈希表，删除对应 k-v
            --size;
            map.remove(delNode.val);
        }
        // 新建节点，移动到头部
        Node newNode = new Node(key);
        moveToHead(newNode);
        // 更新 size 和 map
        ++size;
        map.put(key, new Object[]{newNode, value});
    }

    private void moveToHead(Node curNode) {
        Node temp = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = temp;
        temp.prev = curNode;
    }

    private void removeNode(Node curNode) {
        Node prev = curNode.prev;
        Node next = curNode.next;
        // 断开当前连接
        prev.next = next;
        next.prev = prev;
    }
}
