package test;

import javax.sql.rowset.spi.SyncResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IntegerTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/13 6:29 下午
 * @Version 1.0
 **/
public class IntegerTest {
    public static void main(String[] args) {
        Integer a=123;
        Integer b=123;
        System.out.println(a==b);

        a=128;
        b=128;
        System.out.println(a==b);

        a=-129;
        b=-129;
        System.out.println(a==b);

        Integer c = new Integer(123);
        Integer d = new Integer(123);
        System.out.println(c==d);

        List<?> listHandle;

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();

        listHandle=l1;

        listHandle=l2;

    }
}
