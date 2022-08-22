package javase.innerclass;

public class Anonymous {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer {
    private int n1 = 10;

    public void method() {
    /*
        The anonymous inner class based on interface
        1. Requirement: Use IA interface and create an object
        2. Traditional way is to write a class to implement the interface
           then create an object.
        3. If we just use class Tiger once, then it wouldn't be used anymore.
        4. We can use anonymous inner class to simplify the development.
        5. tiger's compiled type: interface IA
           tiger's running type: anonymous inner class
           XX = Outer$1
           class XX implements IA {
               @Override
               public void cry() {
                   System.out.println("Tiger!");
               }
           }
        6. Once jdk create anonymous inner class Outer$1, the instance would be created immediately.
    */
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("Tiger!");
            }
        };
        System.out.println("Tiger running type: " + tiger.getClass());
        tiger.cry();

    /*
        The anonymous inner class based on class
        1. Father's compiled type: class Father,
           Father's running type: Outer$2

        class Outer$2 extends Father {
        }
     */
        Father father = new Father("Jack") {
            @Override
            public void test() {
                System.out.println("Override method in a inner anonymous class.");
            }
        };
        System.out.println("Father's running type: " + father.getClass());
        father.test();
    }
}

interface IA {
    public void cry();
}

//class Tiger implements IA{
//
//    @Override
//    public void cry() {
//        System.out.println("Tiger!");
//    }
//}

class Father {
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void test() {
    }
}