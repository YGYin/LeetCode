package javase.map;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapSample {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("AA", 20000, 1));
        map.put(2, new Employee("CC", 40000, 2));
        map.put(3, new Employee("BB", 30000, 3));

        // To use keySet
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Employee emp = (Employee) map.get(key);
            if (emp.getSalary() > 20000)
                System.out.println(emp);
        }

        // To use entrySet
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            Employee emp1 = (Employee) entry.getValue();
            if (emp1.getSalary() > 20000)
                System.out.println(emp1);
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "MapSample{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
