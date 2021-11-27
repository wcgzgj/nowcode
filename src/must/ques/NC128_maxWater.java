package must.ques;

/**
 * @ClassName NC128_maxWater
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/27 2:47 下午
 * @Version 1.0
 **/
public class NC128_maxWater {
    public static void main(String[] args) {
        NC128_maxWater solu = new NC128_maxWater();
        System.out.println(solu.maxWater(new int[]{4, 2, 0, 3, 2, 5}));
    }

    // 现在想想，自己这个思路有够奇葩的，
    //public long maxWater (int[] arr) {
    //    if (arr.length<=2) return 0;
    //    long count=0;
    //    int l = getNextBound(-1, arr);
    //    int r = getNextBound(l, arr);
    //    while (l!=-1 && r!=-1 && r-l>1) {
    //        count+=countWater(l,r,arr);
    //        l=r;
    //        r=getNextBound(r,arr);
    //    }
    //    return count;
    //}
    //
    //// 获得下一个边界
    //private int getNextBound(int curr,int[]arr) {
    //    for (int i = curr+1; i <arr.length-1 ; i++) {
    //        if (i==0) {
    //            if (arr[i+1]<arr[i]) return 0;
    //            else continue;
    //        }
    //        if (arr[i-1]<arr[i] && arr[i+1]<arr[i]) return i;
    //    }
    //    if (arr[arr.length-1]<=arr[arr.length-2]) return -1;
    //    return arr.length-1;
    //}
    //
    //private long countWater(int l,int r,int[] arr) {
    //    long count = 0;
    //    int lowerSide = Math.min(arr[l], arr[r]);
    //    for (int i = l+1; i <r ; i++) {
    //        count+=lowerSide-arr[i]>0?lowerSide-arr[i]:0;
    //    }
    //    return count;
    //}

    // 方法二：
    //朴素的做法是对于数组 \textit{height}height 中的每个元素，
    // 分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。
    // 假设数组 \textit{height}height 的长度为 nn，
    // 该做法需要对每个下标位置使用 O(n)O(n) 的时间向两边扫描并得到最大高度，因此总时间复杂度是 O(n^2)
    // 这个方法的代码我就不写了
    //public long maxWater (int[] arr) {
    //
    //}

    // 方法三：动态规划
    // 使用两个数组，leftMax 和 rightMax
    // leftMax[i] 表示位置 i 左侧的位置
    // rightMax[i] 同理
    public long maxWater (int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftMax[0]=arr[0];
        rightMax[arr.length-1]=arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }
        for (int i = arr.length-2; i >=0 ; i--) {
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        long count=0;
        for (int i = 0; i < arr.length; i++) {
            int lowSide = Math.min(leftMax[i], rightMax[i]);
            count+=lowSide-arr[i]>=0?lowSide-arr[i]:0;
        }
        return count;
    }
}
