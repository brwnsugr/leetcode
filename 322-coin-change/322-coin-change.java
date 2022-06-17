class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return getCoinChange(coins, amount, new int[amount]);
    }
    
    
    private int getCoinChange(int[] coins, int remain, int[] count) {
        if(remain < 0) return -1;
        if(remain == 0) return 0;
        if(count[remain - 1] != 0) return count[remain -1];
        
        int min = Integer.MAX_VALUE;
        
        for(int coin : coins) {
            // if(coin <= remain) {
            int res = getCoinChange(coins, remain - coin, count);
            if(res >= 0 && res < min) {
                min = 1 + res;
            }
            // min = Math.min(res, min);
            // }
        }
        count[remain-1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[remain-1];
    }
}