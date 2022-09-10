class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles) right = Math.max(right, pile);
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(feasible(piles, mid, h)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean feasible(int[] piles, int speed, int h) {
        int time = 0;
        for(int pile : piles) {
            int r = pile % speed;
            int q = pile / speed;
            time += q;
            if(r > 0) time += 1;
            if(time > h) return false;
        }
        return true;
    }
}