package must.ques;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC199_topk
 * @Description topk 问题，可以使用堆
 * @Author faro_z
 * @Date 2021/9/19 2:31 下午
 * @Version 1.0
 **/
public class NC199_topk {
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1};
        NC199_topk nc199_topk = new NC199_topk();
        System.out.println(nc199_topk.GetLeastNumbers_Solution(arr,3));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        buildHead(input,input.length);
        for (int i = 1; i <= k; i++) {
            res.add(input[0]);
            swap(input,0,input.length-i);
            heapify(input,0,input.length-i);
        }
        return res;
    }

    // 建堆
    public void buildHead(int[] arr,int n) {
        for (int i = (n/2)-1; i >=0; i--) {
            heapify(arr,i,n);
        }
    }

    // 堆化
    public void heapify(int[] arr,int i,int n) {
        while (i*2+1<n) {
            int child = i * 2 + 1;
            if (child+1<n && arr[child+1]<arr[child]) child++;
            // 说明堆化完成了，不用再进行了
            if (!(arr[child] <arr[i])) return;
            swap(arr,i,child);
            i=child;
        }
    }

    public void swap(int[] arr,int x,int y) {
        int tmp = arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }
}
