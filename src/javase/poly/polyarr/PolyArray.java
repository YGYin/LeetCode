package javase.poly.polyarr;

public class PolyArray {

    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("jack", 18, 90); // 向上转型
        persons[2] = new Student("Alex", 22, 100);
        persons[3] = new Teacher("Scott", 30, 20000);
        persons[4] = new Teacher("Allen", 28, 20000);

        for (int i = 0; i < persons.length; i++) {
            // persons[i] 编译类型是 Person, 运行类型为为右侧
            System.out.println(persons[i].say());

            // 判断person[i]运行类型是不是student，是则强转 向下转型
            if (persons[i] instanceof Student)
/*
                Student stu = (Student) persons[i];
                stu.study();
*/
                ((Student) persons[i]).study();
            else if (persons[i] instanceof Teacher)
                ((Teacher) persons[i]).teach();
            else
                System.out.println("Person.");
        }
    }
}
