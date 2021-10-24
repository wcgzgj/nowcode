package must.ques;

/**
 * @ClassName CC16_candy
 * @Description TODO
 * @Author faro_z
 * @Date 2021/10/24 2:29 下午
 * @Version 1.0
 **/
public class CC16_candy {
    public static void main(String[] args) {

    }

    public int candy (int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i]=1;
        }
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i]>ratings[i-1]) candies[i]=candies[i-1]+1;
        }
        for (int i = candies.length-2; i>=0; i--) {
            if (ratings[i]>ratings[i+1]) candies[i]=Math.max(candies[i+1]+1,candies[i]);
        }
        int count = 0;
        for (int candy : candies) {
            count+=candy;
        }
        return count;
    }
}
