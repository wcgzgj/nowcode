package must.ques;

import java.util.*;

/**
 * @ClassName NC190_generatePermutation
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 11:48 上午
 * @Version 1.0
 **/
public class NC190_generatePermutation {
    private static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        //StringBuilder builder = new StringBuilder();
        //List<String> list = new ArrayList<>();
        //list.add(builder.toString());
        ////list.add("aa");
        //System.out.println(list);
        //System.out.println(list.size());
        NC190_generatePermutation solu = new NC190_generatePermutation();
        String[] res = solu.generatePermutation("aabb");
        System.out.println(Arrays.toString(res));
    }

    public String[] generatePermutation (String s) {
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        builder.append("");
        dfs(builder,chars,0,res);
        String[] strArr = new String[res.size()];
        int index = 0;
        for (String elem : res) {
            strArr[index++]=elem;
        }
        return strArr;
    }

    private void dfs(StringBuilder track,char[] chars,int depth,Set<String>res) {
        if (depth>=chars.length) {
            res.add(track.toString());
            return;
        }

        // 当前位置不选
        dfs(track,chars,depth+1,res);
        // 当前位置选择
        track.append(chars[depth]);
        dfs(track,chars,depth+1,res);
        track.delete(track.length()-1,track.length());
    }
}
