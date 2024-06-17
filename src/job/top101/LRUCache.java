package job.top101;


import java.util.HashMap;
import java.util.Map;

class DLNode {

    int val;
    DLNode prev;
    DLNode next;

    public DLNode(int val) {
        this.val = val;
    }
}

public class LRUCache {

    // map 储存对应值和节点
    Map<Integer, Object[]> map;
    // 包含头尾节点
    DLNode head;
    DLNode tail;
    // 实际容量
    int capacity;
    // 当前 size
    int size;

    public LRUCache(int capacity) {
        // 初始化头尾节点并头尾链接
        head = new DLNode(-1);
        tail = new DLNode(-1);

        head.next = tail;
        tail.prev = head;

        // 初始化 map
        map = new HashMap<>();
        // 初始化 capacity
        this.capacity = capacity;

    }

    public int get(int key) {
        // 看当前节点是否存在
        if (map.containsKey(key)) {
            // 存在的话返回当前 key 的 value，同时将其移到链表的最前面
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // 返回 map 中储存的 value
            return (int) map.get(key)[1];
        }
        return -1;
    }

    public void put(int key, int value) {
        // 先检查是否储存了 key 对应的节点
        if (map.containsKey(key)) {
            // 如果存在，不仅要更新节点中的值，还要将该节点移动到链表头部
            DLNode curNode = (DLNode) map.get(key)[0];
            removeNode(curNode);
            moveNodeToHead(curNode);

            // 更新节点中的 value
            map.put(key, new Object[]{curNode, value});
            return;
        }
        // 不存在，需要 put 当前节点，先看容量是否已满
        if (size == capacity) {
            DLNode delNode = tail.prev;
            // 删除最后面的节点
            removeNode(delNode);
            // 更新 map 中的值
            map.remove(delNode.val);
            // 更新 size
            --size;
        }
        // 再把新节点加入到最前面
        DLNode newNode = new DLNode(key);
        moveNodeToHead(newNode);
        // 更新哈希表
        map.put(key, new Object[]{newNode, value});
        ++size;

        return;
    }

    private void moveNodeToHead(DLNode curNode) {
        // 记录头节点的下一个节点，便于插入当前节点
        DLNode temp = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = temp;
        temp.prev = curNode;
    }

    private void removeNode(DLNode curNode) {
        DLNode prevNode = curNode.prev;
        DLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
