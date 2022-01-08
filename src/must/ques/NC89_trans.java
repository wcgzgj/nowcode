package must.ques;

import java.util.Arrays;
import java.util.Locale;

/**
 * @ClassName NC89_trans
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/8 11:12 上午
 * @Version 1.0
 **/
public class NC89_trans {
    public static void main(String[] args) {
        NC89_trans solu = new NC89_trans();
        System.out.println(solu.trans("This is a sample",16));
        //char[] chars = {'a', 'b', 'c'};
        //solu.reverse(chars,0,chars.length-1);
        //System.out.println(Arrays.toString(chars));
    }

    public String trans(String s, int n) {
        if (n<=1) return s;
        char[] chars = s.toCharArray();
        reverse(chars,0,chars.length-1);
        int l=0,r=0;
        while (r<n) {
            while (r<n && chars[r]!=' ') r++;
            reverse(chars,l,r-1);
            //System.out.println(new String(chars));
            l=r+1;
            r=l;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i]=swapCase(chars[i]);
        }
        return new String(chars);
    }

    // 逆转字符数组
    public void reverse(char[] arr,int l,int r) {
        while (l<r) {
            char tmp = arr[l];
            arr[l]=arr[r];
            arr[r]=tmp;
            l++;
            r--;
        }
    }

    // 大小写转换
    public char swapCase(char c) {
        if (c>=65 && c<=90) return (char) (c+32);
        else if (c>=97 && c<=122) return (char) (c-32);
        return ' ';
    }
}
