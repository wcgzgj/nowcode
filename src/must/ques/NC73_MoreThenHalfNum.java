package must.ques;

import java.util.Arrays;

/**
 * @ClassName NC73_MoreThenHalfNum
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/16 3:32 下午
 * @Version 1.0
 **/
public class NC73_MoreThenHalfNum {
    public static void main(String[] args) {

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0) return 0;
        Arrays.sort(array);
        return array[array.length/2];
    }
}
