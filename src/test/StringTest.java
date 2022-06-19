package test;

import java.util.Arrays;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 12:40
 * @Version 1.0
 **/
public class StringTest {
    public static void main(String[] args) {
        String verStr1 = "1.01.1";
        String[] ver1 = verStr1.split("\\.");
        System.out.println(Arrays.toString(ver1));

    }




}
