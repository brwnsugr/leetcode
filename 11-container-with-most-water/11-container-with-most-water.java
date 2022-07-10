class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int l = 0;
        int r = height.length - 1;
        
        // 
        
        while(l < r) {
            int tempHeight = Math.min(height[l], height[r]);
            int tempArea = tempHeight * (r-l);
            
            answer = Math.max(answer, tempArea);
            
            if(height[l] > height[r]) {
                r--;
            }
            
            else {
                l++;
            }
        }
        
        //[1^,8,6,2,5,4,8,3,7^]  
        
        return answer;
    }
}