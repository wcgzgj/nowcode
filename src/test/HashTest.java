package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName HashTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/19 3:11 下午
 * @Version 1.0
 **/
public class HashTest {
    public static void main(String[] args) {
        String input = "hello world";
        //HashMap<Object, Object> map = new HashMap<>();
        //map.put()
        HashSet<User> set = new HashSet<>();
        User user1 = new User("faroz", 22);
        User user2 = new User("faroz", 22);
        set.add(user1);
        user1.setName("dio");
        System.out.println(set.contains(user2));

    }
}

class User {

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
