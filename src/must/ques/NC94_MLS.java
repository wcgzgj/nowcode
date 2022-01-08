package must.ques;

import java.util.Arrays;

/**
 * @ClassName NC94_MLS
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/8 12:46 下午
 * @Version 1.0
 **/
public class NC94_MLS {
    public static void main(String[] args) {
        NC94_MLS solu = new NC94_MLS();
        // {100,4,200,1,3,2}
        System.out.println(solu.MLS(new int[]{100,4,200,1,3,2}));
        System.out.println(solu.MLS(new int[]{1,1,1}));
    }

    public int MLS (int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        int count = 0;
        int index = 0;
        while (index<arr.length) {
            int nextIndex = moveToNext(arr,index);
            if (nextIndex==-1) {
                return Math.max(max,count+1);
            }
            if (arr[index]+1==arr[nextIndex]) {
                count++;
            }
            else {
                max = Math.max(max, count+1);
                count=0;
            }
            index = nextIndex;
        }
        return max;
    }

    // 去重，移动到下一个不重复位置
    public int moveToNext(int[] arr,int i) {
        while (i+1<arr.length && arr[i]==arr[i+1]) i++;
        if (i==arr.length-1) return -1;
        return i+1;
    }
}
