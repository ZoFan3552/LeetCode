package hot100.GreedyAlgorithm;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        //下降前一天卖掉
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int res = new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }

}
