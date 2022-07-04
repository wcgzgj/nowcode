package test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName ArrayCopyTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/4 17:41
 * @Version 1.0
 **/
public class ArrayCopyTest {
    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[1][1]=10;
        int[][] dummy = Arrays.copyOf(grid, grid.length);
        for (int[] arr : dummy) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
