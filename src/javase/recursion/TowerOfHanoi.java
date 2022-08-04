package javase.recursion;

public class TowerOfHanoi {
    void move(int num, char a, char b, char c) {
        if (num == 1)
            System.out.println(a + " -> " + c);
        else {
            // More than 1 Tower
            // 1. Upper one moves from A to B by C
            move(num - 1, a, c, b);
            // 2. Bottom one moves from A to C directly
            System.out.println(a + " -> " + c);
            // 2. The remaining moves from B to C by A
            move(num - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi();
        tower.move(5, 'A', 'B', 'C');
    }
}
