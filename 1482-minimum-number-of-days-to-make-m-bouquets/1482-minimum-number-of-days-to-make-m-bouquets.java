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
        boolean[] gardens = new boolean[len];
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(bloomDay[i] <= days) gardens[i] = true;
        }
        
        int i = 0;
        while(i < len) {
            int formed = 0;
            boolean form = false;
            while(i < len && formed < k && gardens[i]) {
                formed++;
                i++;
                form = true;
            }
            if(formed == k) count++;
            if(count >= threshold) return true;
            if(!form) i++;
        }
        return false;
    }
}