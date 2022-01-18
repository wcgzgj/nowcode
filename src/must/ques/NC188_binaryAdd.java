package must.ques;

/**
 * @ClassName NC188_binaryAdd
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 11:00 上午
 * @Version 1.0
 **/
public class NC188_binaryAdd {
    public static void main(String[] args) {

    }

    //public String binaryAdd (String A, String B) {
    //    StringBuilder builder = new StringBuilder();
    //    int ar = A.length() - 1;
    //    int br = B.length() - 1;
    //    int cache=0;
    //    while (ar>=0 && br>=0) {
    //        int[] res = add(A.charAt(ar--), B.charAt(br--), cache);
    //        builder.insert(0,res[0]);
    //        cache=res[1];
    //    }
    //    while (ar>=0) {
    //        int[] res = add(A.charAt(ar--), '0', cache);
    //        builder.insert(0,res[0]);
    //        cache=res[1];
    //    }
    //    while (br>=0) {
    //        int[] res = add('0', B.charAt(br--), cache);
    //        builder.insert(0,res[0]);
    //        cache=res[1];
    //    }
    //    if (cache!=0) builder.insert(0, 1);
    //    return builder.toString();
    //}

    public String binaryAdd (String A, String B) {
        StringBuilder builder = new StringBuilder();
        int ar = A.length() - 1;
        int br = B.length() - 1;
        int cache=0;
        while (ar>=0 || br>=0) {
            int[] res = add(ar>=0?A.charAt(ar--):'0', br>=0?B.charAt(br--):'0', cache);
            builder.insert(0,res[0]);
            cache=res[1];
        }
        if (cache!=0) builder.insert(0, 1);
        return builder.toString();
    }

    /**
     * @param c1
     * @param c2
     * @param cache
     * @return res[0]:当前位应该是什么数   res[1]:进位的数   0,1,2
     */
    public int[] add(char c1,char c2,int cache) {
        int[] res = new int[2];
        int tmp = (c1 - '0') + (c2 - '0') + cache;
        res[0]=tmp%2;
        res[1]=tmp/2; // 0,1 进0  2,3 进1
        return res;
    }
}
