package must.ques;

/**
 * @ClassName BM20_InversePairs
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/4 15:33
 * @Version 1.0
 **/
public class BM20_InversePairs {
    private int res = 0;
    // 取模，防溢出
    private static final int MOD = 1000000007;
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return res;
    }

    private void mergeSort(int[] arr,int l,int r) {
        if (l==r) return;
        int mid = (l + r) >>1;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    // 归并
    private void merge(int[]arr,int ls,int le,int re) {
        int[] tmp = new int[re - ls + 1];
        int l = ls;
        int r = le + 1;
        int index = 0;
        while (l<=le && r<=re) {
            if (arr[l]<=arr[r]) tmp[index++]=arr[l++];
            // arr[l] > arr[r]
            else {
                tmp[index++]=arr[r++];
                res =res +( le - l+ 1);
                res = res%MOD;
            }
        }
        while (l<=le) tmp[index++]=arr[l++];
        while (r<=re) tmp[index++]=arr[r++];
        index = 0;
        for (int i = ls; i <=re ; i++) {
            arr[i]=tmp[index++];
        }
    }
}
