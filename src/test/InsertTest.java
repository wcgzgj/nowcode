package test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName InsertTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/4/9 12:31 下午
 * @Version 1.0
 **/
public class InsertTest {
    private static Random random = new Random();
    public static void main(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(100);
        }
        System.out.println("插入前数组为:"+ Arrays.toString(arr));
        insert(2,114514,arr);
        System.out.println("插入后数组为:"+ Arrays.toString(arr));
    }

    public static void insert(int index,int val,int[] arr) {
        for (int i = arr.length-1; i >index ; i--) {
            arr[i]=arr[i-1];
        }
        arr[index]=val;
    }
}
