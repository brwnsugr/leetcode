class Solution {
    
    List<List<Integer>> answers = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        Set<Integer> numSet = new HashSet<>();
        List<Integer> arrList = new ArrayList<>();
        backTrack(nums, numSet, arrList);
        
        return answers;
    }
    
    private void backTrack(int[] nums, Set<Integer> numSet, List<Integer> arrList) {
        if(numSet.size() == nums.length) {
            List<Integer> answer = new ArrayList<>(arrList);
            answers.add(answer);
            arrList = new ArrayList<>();
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!numSet.contains(nums[i])) {
                numSet.add(nums[i]);
                arrList.add(nums[i]);
                backTrack(nums, numSet, arrList);
                numSet.remove(nums[i]);
                arrList.remove(arrList.size()-1);
            }
        }
        
    }
}