package javase.set;

import java.util.HashSet;

public class HashSetSimulation {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("Java");
        hashSet.add("add");
        hashSet.add("Java");

        // HashSet is based on HashMap
        Node[] table = new Node[16];

        Node alex = new Node("Alex", null);
        table[2] = alex;

        alex.next = new Node("Alitta", null);

        table[3] = new Node("hyaki", null);
        System.out.println(table);
    }
}

class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}