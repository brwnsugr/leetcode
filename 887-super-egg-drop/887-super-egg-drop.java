class Solution {
    public int superEggDrop(int k, int n) {
        
        // dp(K,N): max # of moves needed to solve the problem. 
        // 
        // dp(K,N) = 1 + (1<=X<=N) Min(max(dp(n-1, x-1), dp(k, n-x) ))
        
        //즉, dp(K,N)은 dp(n-1, x-1), dp(k, n-x) 두 가지 경우로 각각 쪼개질 수 있고, 
        // 이 중에, 더 큰 값이 dp(K,N) 이 된다. -> 왜냐고? -> dp(N,K) 의 정의 자체가 정확한 낙하한계지점을 알기 위한 최대 낙하 횟수이고, 우리가 설정한 x에 따라 다음 스텝은 dp(k-1, x-1) 과 dp(k, n-x) 로 쪼개지는데, 이 둘 중에 최대값을 고려해야만, dp(n,k) 값이 최대가 되기 때문이다. 
        // 근데, 각각의 dp(n-1, x-1), dp(k, n-x) 의 최대값 pair 중에 가장 작은 값이 dp(k,n)이 된다. 
        // 이유는, x 라는 초기에 우리가 pick하는 낙하지점의 변수가 변할때, 가장 작은 값을 갖는 max(dp(n-1,x-1), dp(k,n-x)) 가, dp(n,k)에서 가장 적은 스텝으로 정확한 낙하한계지점을 구하는 것이기 때문이다. 
        
        
        return dp(k, n);

    }
    
    private Map<Integer, Integer> cache = new HashMap<>();
    private int dp(int k, int n) {
        if(!cache.containsKey(n * 100 + k)) { 
            int ans;
            if(n == 0) ans = 0;
            else if(k == 1) ans = n;
            else {
                int lo = 1;
                int hi = n;
                
                while(lo + 1 < hi) { // lo 와 hi 사이에 최소 한칸은 비어야 있어야 연산을 한다.. 
                    int x = (lo + hi)/2; // x 는 우선 중간값에서 시작한다.
                    int t1 = dp(k-1, x-1);
                    int t2 = dp(k, n-x);
                    
                    if(t1 < t2) { // x에서 깨진 경우가 더 작은 경우 오른쪽을 찾는다.
                        lo = x;
                    }
                    else if( t1 > t2) {
                        hi = x;
                    }
                    else {
                        lo = hi = x;
                    }
                }
                
                ans = 1 + Math.min(Math.max(dp(k-1, lo-1), dp(k, n-lo)), Math.max(dp(k-1, hi-1), dp(k, n-hi)));
            }
            
            cache.put(n * 100 + k, ans);
        }
        
        return cache.get(n * 100 + k);
    }
}