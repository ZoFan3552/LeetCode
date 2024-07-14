package interview150.ArrayAndString;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        //贪心：两遍扫描，确保每个孩子都满足相邻分数的要求
        int[] candies = new int[ratings.length];
        Arrays.fill(candies , 1);//每位孩子至少得到1颗糖
        //从左往右，若比左边孩子高，则糖果数为左边孩子的糖果数加1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        //从右往左，若比右边孩子高，且糖果数不大于对方，则糖果数为对方的糖果数加1
        for (int i = ratings.length - 1 - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }
        }
        int candySum = 0;
        for (int candy : candies) {
            candySum += candy;
        }
        return candySum;
    }

    public static void main(String[] args) {
        int res = new Candy_135().candy(new int[]{1,2,2});
        System.out.println(res);
    }
}
