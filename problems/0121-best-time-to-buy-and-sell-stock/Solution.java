class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = prices[0];
        int maxProfit = 0;
        int currentProfit = 0;

        for(int price = 0; price < prices.length; price++){
            if(prices[price] < minPrice){
                minPrice = prices[price];
            }
            currentProfit = prices[price] - minPrice;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }

        }
        return maxProfit;
    }
}