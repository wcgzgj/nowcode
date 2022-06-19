package must.ques;

/**
 * @ClassName BM22_compare
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 12:39
 * @Version 1.0
 **/
public class BM22_compare {
    public static void main(String[] args) {
        BM22_compare solu = new BM22_compare();
        System.out.println(solu.compare("1.0.1","1"));
    }

    public int compare (String version1, String version2) {
        String[] ver1 = splitAndRemoveZeros(version1);
        String[] ver2 = splitAndRemoveZeros(version2);
        int len = Math.max(ver1.length, ver2.length);
        for (int i = 0; i < len; i++) {
            if (i>=ver1.length) return checkTail(ver2,i)?-1:0;
            else if (i>=ver2.length) return checkTail(ver1,i)?1:0;
            else if (Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i])) return 1;
            else if (Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i])) return -1;
        }
        return 0;
    }

    /**
     * 检查尾部是否全为0，是，返回false
     * @param arr
     * @param index
     * @return
     */
    private boolean checkTail(String[]arr,int index) {
        for (int i = index; i <arr.length ; i++) {
            if (!"0".equals(arr[i])) return true;
        }
        return false;
    }

    private String[] splitAndRemoveZeros(String verStr) {
        String[] split = verStr.split("\\.");
        removeForeZeros(split);
        return split;
    }

    private void removeForeZeros(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]=removeForeZero(arr[i]);
        }
    }

    private String removeForeZero(String str) {
        if ("0".equals(str)) return "0";
        int index = 0;
        while (str.charAt(index)=='0') index++;
        return str.substring(index,str.length());
    }
}
