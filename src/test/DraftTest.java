package test;

import java.util.Scanner;

/**
 * @ClassName DraftTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/16 3:03 下午
 * @Version 1.0
 **/
public class DraftTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入总人数：");
        int all=sc.nextInt();
        int[] nums=new int[all];
        for (int i = 0; i <nums.length ; i++) {
            nums[i]=i+1;
        }
        //遍历数组中的所有人
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+"\t");
        }
        //开始报数，循环
        int left=all;//由于还没有报数，剩余等于所有人
        int baoshu=0;
        System.out.println("\n出局人数：");
        while (left>1){
            for (int i = 0; i <nums.length ; i++) {

                if (baoshu==3){
                    System.out.print(nums[i]+"\t");
                    left--;
                    nums[i]=-1;
                    baoshu=0;
                }
                if (nums[i]!=-1){
                    baoshu++;
                }
            }
        }
        //最后一人为队长
        System.out.println("\n最后队长是：");
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=-1){//当剩余的一人不是-1时，就是队长
                System.out.println(nums[i]);
            }
        }
    }
}
