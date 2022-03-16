package must.ques;

/**
 * @ClassName NC141_isHuiWen
 * @Description TODO
 * @Author faro_z
 * @Date 2022/3/16 2:48 下午
 * @Version 1.0
 **/
public class NC141_isHuiWen {
    public static void main(String[] args) {

    }

    public boolean judge (String str) {
        if (str==null || str.length()==1 || str.length()==0) return true;
        int l = 0;
        int r = str.length() - 1;
        while (l<r) {
            if (str.charAt(l++)!=str.charAt(r--)) return false;
        }
        return true;
    }
}
