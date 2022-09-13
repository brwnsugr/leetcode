class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > sub.get(sub.size() - 1)) sub.add(nums[i]);
            else {
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }

        return sub.size();
    }
    
    
    private int binarySearch(List<Integer> sub, int target) {
        int left = 0;
        int right = sub.size() - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            int midNum = sub.get(mid);
            if(midNum == target) return mid;
            if(midNum > target) {
                right = mid; 
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}