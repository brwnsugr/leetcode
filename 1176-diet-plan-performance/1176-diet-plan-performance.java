class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        //init summation of calories at first
        int intervalSum = 0;
        int totalPoints = 0;
        for(int i = 0; i < k; i++) intervalSum += calories[i];
        
        int r = k-1;
        int l = 0;
        
        while (true) {
            if(intervalSum > upper) totalPoints++;
            if(intervalSum < lower) totalPoints--;
            
            
            
            intervalSum -= calories[l++];
            r++;
            if(r >= calories.length) break;
            intervalSum += calories[r];
        }
        
        return totalPoints;
    }
}