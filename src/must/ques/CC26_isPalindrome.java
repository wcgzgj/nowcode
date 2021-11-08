package must.ques;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CC26_isPalindrome
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/6 9:04 下午
 * @Version 1.0
 **/
public class CC26_isPalindrome {
    public static void main(String[] args) {
        String str = "902";
        CC26_isPalindrome solu = new CC26_isPalindrome();
        System.out.println(solu.isPalindrome(str));
    }
    private static Set<Character> set = new HashSet<>();
    static {
        for (int i = 0; i < 26; i++) {
            set.add((char) ('a'+i));
        }
    }

    public boolean isPalindrome (String s) {
        if (s==null || s.length()<=1) return true;
        s = s.toLowerCase();
        int l=0,r=s.length()-1;
        while (l<r) {
            while (l<s.length() && !set.contains(s.charAt(l))) l++;
            while (r>=0 && !set.contains(s.charAt(r))) r--;
            if (l>=r) return true;
            if (s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}
