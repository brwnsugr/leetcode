class Solution {
    public int maxProfit(int[] prices) {
        //iterating the array, from the left to end
        // while going through, update minimum buying price
        // and check the diff currentPrice that we're at - minimum buying price
        // then maximum of diff would be the answer
        if(prices.length == 1) return 0;
        int answer = 0;
        int minBuyPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            int profit = currPrice - minBuyPrice;
            answer = Math.max(profit, answer);
            minBuyPrice = Math.min(currPrice, minBuyPrice);
        }
        
        
        return answer;
    }
}