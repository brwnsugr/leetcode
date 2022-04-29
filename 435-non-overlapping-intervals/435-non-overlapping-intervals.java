class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //dp[0] = 1
        //dp[1] = dp[0] + 1 = 2; (0th interval 1th interval -> non overlapping)
        //dp[2] = dp[1] + 1 = 3;
        //dp[3] = max(dp[2], dp[1] + 1) = 3; (dp[1] 은 idx 3th interval하고 overlapping 되지 않는 시점의 범위 값이 되는거임) 
        // 0      1.    2.     3.  
        // dp[i] = i번째까지의 누적구간에서 nonoverlapping이 되는 interval의 갯수의 max 값
        // dp[i] = dp[j] //  j = i-1 를 지속적으로 감소(non overlapping이 될떄까지)
        
        // [1, 10], [2,6], [3, 9]
        // (               )   
        //    (       )
        //.       (       )
        
        // (1,3) , (1,2), (2,3)
        // (  )  -> dp[0] = 1
        // (   )   -> dp[1] = dp[0] = 1
        //.   ()  -> dp[2] =  j = 1 -> dp[1]
        //                    j = 0 -> overlapping X -> dp[0] + 1
        //                    max(dp[1], dp[0] +1)
        int len = intervals.length;
        int[] dp = new int[len];
        
        Arrays.sort(intervals, (int[] t1, int[] t2) -> {return t1[0] - t2[0];});
        dp[0] = 1;
        for(int i = 0; i < intervals.length; i++) {
            int max = 1;
            
            for(int j = i-1; j >= 0 ;j--) {
                if(!isOverlapping(intervals[j], intervals[i])) {
                    
                    
                    max = Math.max(max, dp[j] + 1);
                    break;
                }
                else {
   
                    dp[i] = dp[j];
                }
            }
            dp[i] = max;
        }
        
        return len - dp[len-1];
    }
    
    private boolean isOverlapping(int[] intervalStart, int[] intervalEnd) {
        int firstEnd = intervalStart[1];
        int secondStart = intervalEnd[0];
        if(firstEnd > secondStart) return true;
        return false;
    }
}