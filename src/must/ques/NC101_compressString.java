package must.ques;

/**
 * @ClassName NC101_compressString
 * @Description TODO
 * @Author faro_z
 * @Date 2022/1/18 10:46 上午
 * @Version 1.0
 **/
public class NC101_compressString {
    public static void main(String[] args) {
        NC101_compressString solu = new NC101_compressString();
        System.out.println(solu.compressString("aabcccccaaa"));
    }

    public String compressString (String param) {
        StringBuilder builder = new StringBuilder();
        int count=0;
        for (int i = 0; i < param.length(); i++) {
            count++;
            if (i==param.length()-1 || param.charAt(i)!=param.charAt(i+1)) {
                builder.append(param.charAt(i));
                if (count>1) builder.append(count);
                count=0;
            }
        }
        return builder.toString();
    }
}
