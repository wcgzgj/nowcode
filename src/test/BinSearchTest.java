package test;

/**
 * @ClassName BinSearchTest
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/15 12:42 下午
 * @Version 1.0
 **/
public class BinSearchTest {
    public static void main(String[] args) {
        int[] nums={15,16,20,32,45,88};
        //要查找的数据
        int num =32;

        //关键的三个变量：
        //1.最小下标：
        int minIndex=0;
        //2.最大下标：
        int maxIndex=nums.length-1;
        //3.中间数据下标：
        int midIndex=(minIndex+maxIndex)/2;

        while (minIndex<=maxIndex){
            //System.out.println("循环了一次");
            if (nums[midIndex]>num){
                //中间数据较大
                //minIndex=midIndex-1;  这里写错了
                // 应该是下面这样的，改 maxIndex
                maxIndex = midIndex-1;
            }else if (nums[midIndex]<num){
                //中间数据较小
                minIndex=midIndex+1;

            }else{
                //找到数据位置：midIndex
                break;
            }
            if (minIndex>maxIndex){
                midIndex=-1;
                break;
            }
            //当边界发生变化，需要更新中间下标
            midIndex=(minIndex+maxIndex)/2;
        }

        System.out.println("位置："+midIndex);
    }
}
