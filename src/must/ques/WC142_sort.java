package must.ques;

import java.util.Arrays;

/**
 * @ClassName WC142_sort
 * @Description TODO
 * @Author faro_z
 * @Date 2021/9/11 5:08 下午
 * @Version 1.0
 **/
public class WC142_sort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,2,0,12,3};
        WC142_sort wc142_sort = new WC142_sort();
        wc142_sort.MySort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自定义排序算法
     * @param arr
     * @return
     */
    public int[] MySort (int[] arr) {
        //mergeSort(arr,0,arr.length-1);
        //quickSort(arr,0,arr.length-1);
        headSort(arr);
        return arr;
    }

    /**
     * 归并排序
     * @param arr
     */
    public void mergeSort(int[] arr,int l,int r) {
        if (l>=r) return;
        int mid = (l+r) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    /**
     * 归并
     * @param arr
     * @param ls 左半部分开始
     * @param le 左半部分终止
     * @param re 右半部分终止
     */
    private void merge(int[] arr,int ls,int le,int re) {
        int[] tmp = new int[re - ls + 1];
        int l = ls;
        int r = le+1;
        int index = 0;
        while (l<=le && r<=re) {
            if (arr[l]<=arr[r]) {
                tmp[index++]=arr[l++];
            } else {
                tmp[index++]=arr[r++];
            }
        }
        while (l<=le) {
            tmp[index++]=arr[l++];
        }
        while (r<=re) {
            tmp[index++]=arr[r++];
        }
        index=0;
        for (int i = ls; i <= re; i++) {
            arr[i]=tmp[index++];
        }
    }

    /**
     * 快速排序
     * @param arr
     */
    public void quickSort(int[]arr,int l,int r) {
        if (l>=r) return;
        int pivot = partition(arr, l, r);
        quickSort(arr,l,pivot-1);
        quickSort(arr,pivot+1,r);
    }

    private int partition(int[] arr,int l,int r) {
        int index = l + 1;
        int pivotVal = arr[l];
        for (int i = index; i <= r; i++) {
            if (arr[i]<pivotVal) {
                swap(arr,index,i);
                index++;
            }
        }
        swap(arr,index-1,l);
        return index-1;
    }


    /**
     * 堆排序
     * @param arr
     */
    public void headSort(int[] arr) {
        heapify(arr,arr.length);
        int k = arr.length;
        while (k>=1) {
            swap(arr,0,k-1);
            heapAdjust(arr,0,--k);
        }
    }

    // 数组堆化
    private void heapify(int[] arr,int n) {
        for (int i = n/2-1; i >=0; i--) {
            heapAdjust(arr,i,n);
        }
    }

    // 堆调整
    private void heapAdjust(int[] arr,int i,int n) {
        int child = i * 2 + 1;
        while (child<n) {
            if (child+1<n && arr[child+1]>arr[child]) child++;
            if (!(arr[child]>arr[i])) break;
            swap(arr,child,i);
            i=child;
            child = i * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 用这种排序，不知道为什么，快排会出问题......
    //public void swap(int[]arr,int x,int y) {
    //    arr[x]=arr[y]-arr[x];
    //    arr[y]=arr[y]-arr[x];
    //    arr[x]=arr[y]+arr[x];
    //}
}
