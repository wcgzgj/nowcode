package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashMapSrtTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/21 1:12 下午
 * @Version 1.0
 **/
public class HashMapSrtTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3,5);
        map.put(1,8);
        map.put(0,12);
        map.put(9,543);
        map.put(2,21);
        map.put(7,764);

        System.out.println(map);
    }
}
