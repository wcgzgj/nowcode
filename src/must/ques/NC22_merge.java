package must.ques;

/**
 * @ClassName NC22_merge
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 12:04 上午
 * @Version 1.0
 **/
public class NC22_merge {
    public static void main(String[] args) {

    }

    public void merge(int A[], int m, int B[], int n) {
        int curr = m+n-1;
        int a = m-1,b=n-1;
        while (a>=0 && b>=0) {
            if (A[a]>=B[b]) A[curr--]=A[a--];
            else A[curr--]=B[b--];
        }
        while (a>=0) A[curr--]=A[a--];
        while (b>=0) A[curr--]=B[b--];
    }
}
