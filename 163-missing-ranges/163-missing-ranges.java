class Solution {
    
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        int prev = lower - 1;
        List<String> ranges = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            
            if(prev + 1 <= curr -1) ranges.add(getPartialRange(prev, curr, lower, upper));
            
            prev = curr;
        }
            
        return ranges;
    }
    
    
    private String getPartialRange(int start, int end, int lower, int upper) {
        int rangeStart = 0;
        int rangeEnd = 0;

        rangeStart = Math.max(lower, start + 1);
        rangeEnd = Math.min(upper, end - 1);
        
        if(rangeStart == rangeEnd) return String.valueOf(rangeStart);
        
        return String.valueOf(rangeStart) + "->" + String.valueOf(rangeEnd);
    }
}