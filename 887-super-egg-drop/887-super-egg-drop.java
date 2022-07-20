class Solution {
    
    private Map<Integer, Integer> cache = new HashMap<>();
    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }
    
    private int dp(int k, int n) {
        int ans = 0;
        if(cache.containsKey(n*100 + k)) {
            return cache.get(n*100 + k);
        }
        else if(n == 0) ans = 0;
        // else if(n == 1) ans =  1;
        else if(k == 1) ans = n;
        else {
            int lo = 1;
            int hi = n;
            
            
            while(lo + 1 < hi) {
                int x = (lo + hi) / 2;
                int t1 = dp(k-1, x-1);
                int t2 = dp(k, n-x);
                
                if(t1 > t2) {
                    hi = x; 
                }
                else if(t1 < t2) {
                    lo = x;
                }
                else {
                    lo = x;
                    hi = x;
                }
            }
            
            ans = 1 + Math.min(Math.max(dp(k, n-lo), dp(k-1, lo-1)), Math.max(dp(k, n-hi), dp(k-1, hi-1)));
            
        }
        cache.put(n*100+k, ans);
        return cache.get(n*100+k);
    }
}