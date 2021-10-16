package test;

import java.util.Scanner;

/**
 * @ClassName CaptionTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/16 3:04 下午
 * @Version 1.0
 **/
public class CaptionTest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入总人数：");
        int all=input.nextInt();
        int[] nums=new int[all];//所有人放在数组中
        for (int i = 0; i <nums.length ; i++) {
            //给人们编号
            nums[i]=i+1;
        }
        //列出总人数
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+"\t");
        }
        int Baoshu=0;//报数
        int left=all;//剩余人数，由于还没有开始报数，所以剩余人数等于总人数
        System.out.println("\n出局人数：");
        while (left>1){//只有剩余人数大于1时才能继续循环
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]!=-1){//只有没有出局的人才能接着报数
                    Baoshu++;
                }
                //出局
                if (Baoshu==3){
                    System.out.print(nums[i]+"\t");
                    nums[i]=-1;
                    left--;
                    Baoshu=0;

                }
            }
        }
        //最后队长选择
        System.out.println("\n最后的队长是：");
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=-1){
                System.out.println(nums[i]);
            }
        }
    }
}
