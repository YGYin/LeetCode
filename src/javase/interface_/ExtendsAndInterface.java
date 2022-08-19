package javase.interface_;

public class ExtendsAndInterface {
    public static void main(String[] args) {
        LittleMonkey george = new LittleMonkey("George");
        george.climbing();
        george.swimming();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println("Monkey " + name + "can climbing.");
    }

    public String getName() {
        return name;
    }
}

interface Fishable {
    public void swimming();
}

class LittleMonkey extends Monkey implements Fishable {

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println("Monkey " + getName() + " implements Fishable, it can swim now.");
    }
}
