package P4_BestTimeBuySellStock;

public class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            profit = prices[i] - min;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {1,5,2,6};
        System.out.println(maxProfit(stockPrices));
    }
}
