package round2.tree.level;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
