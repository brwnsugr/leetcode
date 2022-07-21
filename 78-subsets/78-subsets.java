class Solution {
    
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0, nums, new ArrayList<>());
        return answer;
    }
    // [1,2]
    // currIdx = 1, nums = [1,2], list = {1, 2}
    private void generateSubsets(int currIdx, int[] nums, List<Integer> list) {
        if(currIdx == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        else {
            list.add(nums[currIdx]);
            generateSubsets(currIdx+1, nums, list);
            list.remove(list.size() - 1);
            generateSubsets(currIdx+1, nums, list);
        }
        
        
    }
}