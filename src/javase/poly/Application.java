package javase.poly;

public class Application {

    public static void main(String[] args) {
        // Animal 为编译类型已确定，Dog 为运行类型
        Animal animal = new Dog();
        animal.cry();   // 对于运行方法的选择，取决于其运行类型

        // 对象引用指向 Cat
        animal = new Cat();
        animal.cry();

    }


}
