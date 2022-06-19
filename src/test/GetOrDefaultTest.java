package test;

import java.util.*;

/**
 * @ClassName GetOrDefaultTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 17:52
 * @Version 1.0
 **/
public class GetOrDefaultTest {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = Arrays.asList(1, 1, 2, 4, 5, 5, 5, 6);
        for (Integer elem : list) {
            map.putIfAbsent(elem,new ArrayList<>());
            map.get(elem).add(elem);
        }
        System.out.println(map);
    }
}
