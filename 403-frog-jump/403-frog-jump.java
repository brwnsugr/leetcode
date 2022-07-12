class Solution {
    
    private int[][] cache;
    public boolean canCross(int[] stones) {
        cache = new int[stones.length][stones.length];
        
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return isLandingValid(stones, 0, 0) == 1;
    }
    
    private int isLandingValid(int[] stones, int currIdx, int prevGap) {
        if(cache[currIdx][prevGap] >= 0) return cache[currIdx][prevGap];
        for(int nextIdx = currIdx + 1; nextIdx < stones.length; nextIdx++) {
            int currGap = stones[nextIdx] - stones[currIdx];
            if(currGap >= prevGap - 1 && currGap <= prevGap + 1) {
                if(isLandingValid(stones, nextIdx, currGap) == 1) {
                    cache[currIdx][prevGap] = 1;
                    return 1;
                } 
            }
        }
        cache[currIdx][prevGap] = currIdx == stones.length - 1 ? 1 : 0;
        return cache[currIdx][prevGap];
    }
}