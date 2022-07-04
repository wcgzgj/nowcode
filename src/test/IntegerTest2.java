package test;

/**
 * @ClassName IntegerTest2
 * @Description TODO
 * @Author faro_z
 * @Date 2022/7/2 18:40
 * @Version 1.0
 **/
public class IntegerTest2 {
    public static void main(String[] args) {
        System.out.println(new Integer(127)==new Integer(127));
        System.out.println(new Integer(127)==127);
        System.out.println(127==new Integer(127));
        System.out.println(new Integer(127).equals(new Integer(127)));
        Integer a1=128;
        Integer a2=128;
        System.out.println(a1==a2);
        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
    }
}
