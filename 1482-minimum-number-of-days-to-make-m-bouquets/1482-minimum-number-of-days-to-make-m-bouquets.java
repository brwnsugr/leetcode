class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = 0;
        if(bloomDay.length < m * k) return -1;
        for(int eachBloomDay : bloomDay) {
            left = Math.min(eachBloomDay, left);
            right = Math.max(eachBloomDay, right);
        }
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(feasible(bloomDay, mid, m, k)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean feasible(int[] bloomDay, int days, int threshold, int k) {
        
        int len = bloomDay.length;
        int flowers = 0;
        int bouquets = 0;
        for(int bloom : bloomDay) {
            if(days < bloom) {
                flowers = 0;
            }
            else {
                bouquets += (flowers + 1) / k;
                flowers = (flowers + 1) % k;
                if(bouquets >= threshold) return true;
            }
            
        }
        return false;
    }
}