class Solution {
    private List<List<Integer>> res;
    
    int count;
    int len;
    
    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        res = new ArrayList<>();
        
        
        for(int i = 0; i <= len; i++) {
            List<Integer> trace = new ArrayList<>();
            count = i;
            backTrack(0, nums, trace, 0);
        }
        return res;
    }
    
    private void backTrack(int firstIdx, int[] nums, List<Integer> trace, int currentCount) {
        if(currentCount == count) {
            res.add(new ArrayList<>(trace));
            return;
        }
        
        for(int i = firstIdx; i < len; i++) {
            trace.add(nums[i]);
            backTrack(i+1, nums, trace, currentCount+1);
            trace.remove(trace.size()-1);
        }
    }
}