package must.ques;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

/**
 * @ClassName NC142_solve
 * @Description TODO
 * @Author faro_z
 * @Date 2021/12/1 2:53 下午
 * @Version 1.0
 **/
public class NC142_solve {
    public static void main(String[] args) {
        NC142_solve solu = new NC142_solve();
        System.out.println(solu.solve("abcabcab"));
    }

    public int solve (String a) {
        if (a.length()<=1) return 0;
        // size不可能超过原串的一半
        // 字符串长度从大到小枚举，这样只要出现答案，我们直接返回即可
        for (int size = a.length()/2; size >=1 ; size--) {
            // 第二层循环，枚举的是起始位置
            for (int start = 0; start < a.length() - size; start++) {
                String currSub = a.substring(start, start+size);
                int l=start+size,r=l+size-1;
                int count=1; // count 至少要为2，才说明至少出现了一次重复
                while (r<a.length()) {
                    if (!currSub.equals(a.substring(l,r+1))) break;
                    count++;
                    l=r+1;
                    r=l+size-1;
                }
                //if (count>1) res=Math.max(res,count*size);
                if (count>1) return count*size;
            }
        }
        return 0;
    }
}
