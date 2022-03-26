class Solution {
    public void sortColors(int[] nums) {
        // Naive Approach is sort 
        
        // nums
        
        // nums1 = [2,0,2,1,1,0];
        
        Map<Integer, Integer> visitCount = new HashMap<>();
        
        for(int num : nums) {
            if(!visitCount.containsKey(num)){
                visitCount.put(num, 1);
            }
            else {
                visitCount.put(num, visitCount.get(num) + 1);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visitCount.containsKey(0) && visitCount.get(0) > 0) {
                nums[i] = 0;
                visitCount.put(0, visitCount.get(0) - 1);
            }
            else if(visitCount.containsKey(1) && visitCount.get(1) > 0) {
                nums[i] = 1;
                visitCount.put(1, visitCount.get(1) - 1);
            }
            else if(visitCount.containsKey(2) && visitCount.get(2) > 0) {
                nums[i] = 2;
                visitCount.put(2, visitCount.get(2) - 1);
            }
        }
        return;
        
    }
}