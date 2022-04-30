package test;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/29 6:41 下午
 * @Version 1.0
 **/
public class OptionalTest {
    public static void main(String[] args) {
        OptionalUser user = new OptionalUser();
        System.out.println(Optional.ofNullable(user.getName()).orElse("FARO_Z"));
    }
}

class OptionalUser {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
