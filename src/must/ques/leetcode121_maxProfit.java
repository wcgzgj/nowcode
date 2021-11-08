package must.ques;

/**
 * @ClassName leetcode121_maxProfit
 * @Description CC27 的简单版本，只要进行一次交易即可
 * @Author faro_z
 * @Date 2021/11/8 3:03 下午
 * @Version 1.0
 **/
public class leetcode121_maxProfit {
    // 超时
    //public int maxProfit(int[] prices) {
    //    int maxRes = Integer.MIN_VALUE;
    //    for (int i = 0; i < prices.length-1; i++) {
    //        for (int j = i+1; j < prices.length; j++) {
    //            maxRes=Math.max(maxRes,prices[j]-prices[i]);
    //        }
    //    }
    //    if (maxRes<0) return 0;
    //    return maxRes;
    //}

    // 一次遍历
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice) minPrice=prices[i];
            else maxValue=Math.max(maxValue,prices[i]-minPrice);
        }
        return maxValue>0?maxValue:0;
    }
}
