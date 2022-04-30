package must.ques;

/**
 * @ClassName BM18_Find
 * @Description 二维数组的查找
 * @Author faro_z
 * @Date 2022/4/30 2:22 下午
 * @Version 1.0
 **/
public class BM18_Find {
    public static void main(String[] args) {
        //7,[[1,2,8,9],[4,7,10,13]]
        BM18_Find solu = new BM18_Find();
        int[][] arr = {
                {1, 2, 8, 9},
                {4, 7, 10, 13}
        };
        solu.Find(7,arr);
    }

    //// 方法一：遍历+基础二分思想
    //public boolean Find(int target, int [][] array) {
    //    if (array==null || array.length==0) return false;
    //    for (int i = 0; i < array.length; i++) {
    //        if (inBound(array[i],target)) {
    //            if (inArr(array[i],target)) return true;
    //        }
    //    }
    //    return false;
    //}
    //
    //public boolean inArr(int[] arr,int target) {
    //    if (arr==null || arr.length==0) return false;
    //    int l = 0;
    //    int r = arr.length - 1;
    //    int mid = (l + r) / 2;
    //    while (l<=r) {
    //        if (arr[mid]==target) return true;
    //        if (arr[mid]<target) l=mid+1;
    //        else r=mid-1;
    //        mid = (l+r)/2;
    //    }
    //    return false;
    //}
    //
    //public boolean inBound(int[]arr,int target) {
    //    if (arr==null || arr.length==0) return false;
    //    if (target>=arr[0] && target<=arr[arr.length-1]) return true;
    //    return false;
    //}

    // 方法2：依靠题目的特性
    public boolean Find(int target, int [][] array) {
        if (array==null || array.length==0) return false;
        int Rit = array[0].length-1;
        int T = 0;
        int r = array.length-1;
        int c = 0;
        while (r>=T && c<=Rit) {
            int curr = array[r][c];
            if (curr==target) return true;
            if (curr<target) c++;
            else r--;
        }
        return false;
    }
}
