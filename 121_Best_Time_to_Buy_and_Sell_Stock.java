Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    
    // solu 2: better than solu 1
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length <= 1)
            return 0;
        
        int maxProfit = 0;
        int maxBuyDay = 0;
        int maxSellDay = 0;
        
        int profit = 0;
        int buyDay = 0;
        
        for(int i = 1; i < prices.length; i++){
            if( prices[i] >= prices[i-1] ){
                if( (i+1 < prices.length && prices[i] > prices[i+1] ) || i+1 == prices.length ){
                    profit = prices[i] - prices[buyDay];
                    
                    if( profit > maxProfit ){
                        maxProfit = profit;
                        maxBuyDay = buyDay;
                        maxSellDay = i;
                    }
                }
            }
            else{
                if( prices[i] < prices[buyDay] )
                    buyDay = i;
            }
        }
        
        return maxProfit;
    }  
    
    
    // solu 1: works. not as good as solu 2.
/*    
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0)
            return 0;
        
        int[] highestPriceDaySinceToday = getHighestPriceSinceToday(prices);
        
        int maxProfit = Integer.MIN_VALUE;
        int buyDay = -1;
        int sellDay = -1;
        
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            profit = prices[ highestPriceDaySinceToday[i] ] - prices[i];
            
            if( profit > maxProfit ){
                maxProfit = profit;
                buyDay = i;
                sellDay = highestPriceDaySinceToday[i];
            }
        }
        
        return maxProfit;
    }
    
    public int[] getHighestPriceSinceToday(int[] prices){
        int[] highestPriceDaySinceToday = new int[prices.length];
        
        int highestPrice = Integer.MIN_VALUE;
        int highestPriceDay = Integer.MIN_VALUE;
        
        int price = 0;
        for(int i = prices.length-1; i >= 0; i--){
            price = prices[i];
            
            if( price > highestPrice ){
                highestPrice = price;
                highestPriceDay = i;
            }
            
            highestPriceDaySinceToday[i] = highestPriceDay;
        }
        
        return highestPriceDaySinceToday;
    }
*/    
    
}
