# 121. [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `1 ms`
- **Memory:** `94.6 MB`
- **Solved Date:** June 18, 2026 (05:10 UTC)

---

## 💻 Solution
```java
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
```
