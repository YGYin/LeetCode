package javase.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("01", new User(1, 20, "AA"));
        dao.save("02", new User(2, 22, "CC"));
        dao.save("03", new User(3, 21, "BB"));

        List<User> list = dao.list();
        System.out.println("List: " + list);

        dao.update("03", new User(3, 22, "DD"));

        list = dao.list();
        System.out.println("List: " + list);

        System.out.println("id = 02: " + dao.get("03"));
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    // Return all the T instance in the map,
    // Traverse map[K-V], put all the value(T entity) into an arraylist
    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = map.keySet();
        for (String key : keySet)
            list.add(get(key)); // or map.get(key) is OK

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}