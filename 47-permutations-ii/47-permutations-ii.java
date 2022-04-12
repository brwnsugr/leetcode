class Solution {
    
    private int[] inputNums;
    private Set<String> visited;
    List<List<Integer>> answers;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //TC: N : nums length,
        // TC: N * N!
        
        //Naive approach: try to generate all the combs, should not count the duplicated element
        
        // TC: N * N! 
        inputNums = nums;
        visited = new HashSet<>();
        answers = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        perm(0, nums);
        return answers;
    }
    
    
    
    private void perm(int idx, int[] nums) {
        int size = nums.length;
        if(idx == nums.length) {
            String concatPath = "";
            for(int element : nums) concatPath += Integer.toString(element);
            if(!visited.contains(concatPath)) {
                List<Integer> temp = new ArrayList<>();
                for(int num : nums) temp.add(num);
                answers.add(temp);
                visited.add(concatPath);
            }
            return;
        }
        
        for(int swapIdx = idx; swapIdx < size; swapIdx++) {
            int temp = nums[swapIdx];
            nums[swapIdx] = nums[idx];
            nums[idx] = temp;
            perm(idx+1, nums);
            temp = nums[idx];
            nums[idx] = nums[swapIdx];
            nums[swapIdx] = temp;
        }
    }
}