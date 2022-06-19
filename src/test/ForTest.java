package test;

/**
 * @ClassName ForTest
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/14 01:01
 * @Version 1.0
 **/
public class ForTest {
    public static void main(String[] args) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < 5; i++, dev *= 10, mod *= 10) {
            System.out.println("i,dev,mod:"+i+","+dev+","+mod);
        }
    }
}
