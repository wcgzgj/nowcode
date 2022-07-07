package test;

import java.util.HashMap;

/**
 * @ClassName HashCodeTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/7 15:18
 * @Version 1.0
 **/
public class HashCodeTest {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        for (Integer elem : arr) {
            System.out.println(elem.hashCode());
        }
        //new HashMap<>()
    }
}
