package must.ques;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName NC121_Permutation
 * @Description TODO
 * @Author faro_z
 * @Date 2021/11/27 2:08 下午
 * @Version 1.0
 **/
public class NC121_Permutation {
    public static void main(String[] args) {
        NC121_Permutation solu = new NC121_Permutation();
        System.out.println(solu.Permutation("ABC"));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        boolean[] visited = new boolean[str.length()];
        backTrack(str,res,new StringBuilder(),visited);
        return res;
    }

    private void backTrack(String str,ArrayList<String> res,StringBuilder builder,boolean[] visited) {
        // 递归终止条件
        if (builder.toString().length()==str.length()) {
            res.add(builder.toString());
            return;
        }
        // 存储已经用过的 char，防止出现重复的字符
        HashSet<Character> usedCharSet = new HashSet<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && !usedCharSet.contains(str.charAt(i))) {
                usedCharSet.add(str.charAt(i));
                builder.append(str.charAt(i));
                visited[i]=true;
                backTrack(str,res,builder,visited);
                // 回溯
                builder.replace(builder.length()-1,builder.length(),"");
                visited[i]=false;
            }
        }
    }
}
