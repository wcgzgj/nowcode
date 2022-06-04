package must.ques;

/**
 * @ClassName BM21_minNumberInRotateArray
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/4 15:43
 * @Version 1.0
 **/
public class BM21_minNumberInRotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2};
        BM21_minNumberInRotateArray solu = new BM21_minNumberInRotateArray();
        System.out.println(solu.minNumberInRotateArray(arr));
    }

    //public int minNumberInRotateArray(int [] array) {
    //    // 寻峰法在这道题上不使用，因为本体用例不能保证数字不相同
    //    int l = 0;
    //    int r = array.length - 1;
    //    while (l<r) {
    //        int mid = (l + r) >> 1;
    //        if (array[mid]<=array[mid+1]) r = mid;
    //        else l = mid+1;
    //    }
    //    return array[r+1];
    //}

    /**
     * 二分法的变体
     * 但是这道题多了一个数组中的数字可能相同的情况
     * 一旦遇到相同，我们只能这部分剥离出来，使用遍历法进行查找
     *
     * 一般的二分法，我们的范围边界都是一个数，而这道二分法非变体题，边界则是两个区间
     * 依照题目的要求，前边界最小的数，一定大于后边界最大的数
     * 所以两个指针l，r,一个在前边界，一个在后边界，一定是 num[l]>num[r]
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int l = 0;
        int r = array.length - 1;
        if (array[l]<array[r]) return array[l];
        // 范围不再是单个的数，而是两个边界
        while (array[l]>=array[r]) {
            if (r-l==1) return array[r];
            int mid = (l + r) >> 1;
            if (array[l]==array[r]) return midOrder(array,l,r);
            if (array[mid]<array[r]) r = mid;
            else l = mid;
        }
        return array[r];
    }

    // 顺序遍历，寻找最小的数（二分查找的数组中，不能出现重复的数，有重复，只能遍历）
    private int midOrder(int[]arr,int l,int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r ; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
