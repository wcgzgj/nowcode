package must.ques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WC143_foundOnceNumber
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/10 1:31 下午
 * @Version 1.0
 **/
public class WC143_foundOnceNumber {
    public static void main(String[] args) {
        WC143_foundOnceNumber solu = new WC143_foundOnceNumber();
        int[] arr = {0,0,-119,0,0,-119,99,-132,-119,-119,-119,0,-132,-132,-132,-132};
        System.out.println(solu.foundOnceNumber(arr,5));
    }
    // 方法1：使用 map
    //public int foundOnceNumber (int[] arr, int k) {
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for (int num : arr) {
    //        countNum(map,num);
    //    }
    //    for (Integer key : map.keySet()) {
    //        if (map.get(key)==1) return key;
    //    }
    //    return -1;
    //}
    //
    //public void countNum(Map<Integer,Integer>map,int num) {
    //    if (map.get(num)==null) {
    //        map.put(num,1);
    //        return;
    //    }
    //    map.put(num,map.get(num)+1);
    //}


    // 方法二：使用排序
    public int foundOnceNumber (int[] arr, int k) {
        if (arr.length<2) return arr[0];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i==0 && arr[i]!=arr[i+1]) return arr[i];
            if (i==arr.length-1 && arr[i]!=arr[i-1]) return arr[i];
            if (i!=0 && i!=1 && arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) return arr[i];
        }
        return -1;
    }
}
