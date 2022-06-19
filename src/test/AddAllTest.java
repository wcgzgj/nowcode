package test;

import sun.text.CollatorUtilities;

import java.util.*;

/**
 * @ClassName AddAllTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 17:22
 * @Version 1.0
 **/
public class AddAllTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll((Collection<? extends Integer>) Optional.ofNullable(null).orElseGet(()-> Arrays.asList(1,2,3)));
        System.out.println(list);
    }
}
