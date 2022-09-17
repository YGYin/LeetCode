package javase.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ken", 20000, new MyDate(2000, 11, 11)));
        employees.add(new Employee("Alex", 25000, new MyDate(2000, 8, 8)));
        employees.add(new Employee("Lujo", 22000, new MyDate(2000, 12, 12)));
        System.out.println("Employees: " + employees);

        employees.sort(new Comparator<Employee>() {
            // Name -> Birthday
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee && emp2 instanceof Employee))
                    return 0;
                int i = emp1.getName().compareTo(emp2.getName());
                // The names are not the same
                if (i != 0)
                    return i;
                // Put the compare part of birthday in MyDate
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("After sorting: ");
        System.out.println("Employees: " + employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}