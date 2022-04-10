package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName ListSortTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/10 4:20 下午
 * @Version 1.0
 **/
public class ListSortTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(r.nextInt(100));
        }
        list.sort((o1,o2)->o1-o2);
        System.out.println(list);
    }
}
