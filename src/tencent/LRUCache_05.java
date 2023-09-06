package tencent;

import java.util.HashMap;
import java.util.Map;

class LinkNode {
    int key;
    int val;
    LinkNode prev;
    LinkNode next;

    public LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache_05 {
    // 双向链表 (记录顺序) + HashMap (查询链表是否包含所需数据)
    int capacity;
    Map<Integer, LinkNode> map = new HashMap<>();

    LinkNode head = new LinkNode(0, 0);
    LinkNode tail = new LinkNode(0, 0);

    public LRUCache_05(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
        获取数据时，先检查 map 中是否已经存在
        如果存在
            - 进行了操作，将其放到头节点后
            - 返回该节点的值
        如果不存在
            - 返回 -1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            moveNodeToTop(node);
            return node.val;
        }
        return -1;
    }

    /*
        插入数据时，先检查 map 中是否已经存在
        如果不存在
            - 没超出范围就把数据插入到最前面
            - 如果超出了范围就删除掉最后一个，再插入到最前面
        如果已经存在
            - 取得该节点，修改对应的值
            - 因为值被修改，将该节点移到最前面 (头节点后)
     */
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity)
                deleteLastNode();

            // 在头部插入节点
            LinkNode temp = head.next;
            LinkNode newNode = new LinkNode(key, value);
            head.next = newNode;
            newNode.prev = head;
            newNode.next = temp;
            temp.prev = newNode;
            map.put(key, newNode);
        } else {
            LinkNode curNode = map.get(key);
            curNode.val = value;
            // 因为对该节点进行了操作，需要将其放到最前面
            moveNodeToTop(curNode);
        }
    }

    private void moveNodeToTop(LinkNode node) {
        // 先处理未移动前的前后节点关系
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 再将节点插入到头节点后
        LinkNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void deleteLastNode() {
        LinkNode lastNode = tail.prev;
        LinkNode temp = lastNode.prev;
        temp.next = tail;
        tail.prev = temp;
        map.remove(lastNode.key);
    }
}
