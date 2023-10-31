package top75.arrays;

public class StockBuyAndSell {

    /**
     * LeetCode 217. Contains Duplicate
     * **/
    public static int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;

        for (int i =1 ; i < prices.length; i++){
            if (prices[i] - minBuy < 0){
                minBuy = prices[i];
            } else if ((prices[i] - minBuy) > maxProfit){
                maxProfit = prices[i] - minBuy;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = {3,8,1,5,4,3,1};
        System.out.println(maxProfit(input));
    }
}
