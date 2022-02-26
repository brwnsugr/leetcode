class Solution {
    
    List<List<Integer>> answers = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        /**
        0개: 1, 1개: 3, 2개: 
        */
        List<Integer> res;
        for(int i = 0; i <= nums.length; i++) {
            res = new ArrayList<>();
            recursive(0, nums, res, 0, i);
        }
        return answers;
    }
    
    
    private void recursive(int firstIdx, int[] nums, List<Integer> res, int currentCount, int target) {
        
        
        if(currentCount == target) {
            List<Integer> answer = new ArrayList<>(res);
            answers.add(answer);
            return;
        }
        
        
        for(int i = firstIdx; i < nums.length; i++) {
            res.add(nums[i]);
            recursive(i+1, nums, res, currentCount + 1, target);
            res.remove(res.size()-1);
        }
    }
}