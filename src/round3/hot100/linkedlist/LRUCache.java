package round3.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

class DLNode {
    int keyVal;
    DLNode prev;
    DLNode next;

    public DLNode() {
    }

    public DLNode(int val) {
        this.keyVal = val;
    }
}

public class LRUCache {

    // 需要定义头尾节点，容量，当前 size 及 map
    DLNode head;
    DLNode tail;
    int capacity;
    int size;

    // key: 对应 key  val: Object[]{DLNode(key), value}
    Map<Integer, Object[]> map;

    public LRUCache(int capacity) {
        // 初始化头尾节点
        head = new DLNode(-1);
        tail = new DLNode(-1);
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
    }

    // 如果存在 key 对应节点，将其移动到链表头部，同时返回值，否则返回 -1
    public int get(int key) {
        if (map.containsKey(key)) {
            DLNode curNode = (DLNode) map.get(key)[0];
            // 断开节点当前位置连接，将其移动到头部
            removeNode(curNode);
            moveNodeToHead(curNode);
            // val: Object[]{DLNode(key), value}
            return (int) map.get(key)[1];
        }
        return -1;
    }

    /*
        先检查是否存在，如果存在则更改 val，并将节点移动到头部
        如果不存在，检查容量是否已满
        - 如果已满，删除链表中的节点，删除 map 中的键值对，--size
        - 没满，新建并加入节点，map 中添加键值对，移动到头部，++size
     */
    public void put(int key, int value) {
        // 如果存在则更新节点
        if (map.containsKey(key)) {
            // 取出节点，待会用于更新 put
            DLNode curNode = (DLNode) map.get(key)[0];
            // 移动到头部
            removeNode(curNode);
            moveNodeToHead(curNode);
            // 更新 value
            map.put(key, new Object[]{curNode, value});
            return;
        }
        // key 不存在，看容量是否已满
        if (size == capacity) {
            // 移除末尾节点
            DLNode node = tail.prev;
            removeNode(node);
            // 移除 map 中的键值对，DLNode 中存着对应的 key
            map.remove(node.keyVal);
            --size;
        }
        // 新建节点加入到链表头中，同时更新 map，size
        DLNode newNode = new DLNode(key);
        moveNodeToHead(newNode);
        map.put(key, new Object[]{newNode, value});
        ++size;
    }

    private void removeNode(DLNode curNode) {
        DLNode prevNode = curNode.prev;
        DLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveNodeToHead(DLNode curNode) {
        DLNode nextNode = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = nextNode;
        nextNode.prev = curNode;
    }
}
