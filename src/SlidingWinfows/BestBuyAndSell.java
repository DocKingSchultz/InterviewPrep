package SlidingWinfows;

//Best Time to Buy and Sell Stock
//You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
//
//You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
//
//Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
//Input: prices = [10,1,5,6,7,1]
//
//Output: 6
//Input: prices = [10,8,7,5,2]
//
//Output: 0

public class BestBuyAndSell {
    public int maxProfit(int[] prices) {
        int minimumPrize = Integer.MAX_VALUE;
        int sellIndex = 0;
        int bestProfit = 0;
        for (int price : prices) {
            if (price < minimumPrize) {
                minimumPrize = price;
            } else {
                bestProfit = Math.max(bestProfit, price - minimumPrize);
            }
        }
        return  bestProfit;
    }
}
