class Solution {
    
    Set<String> seen = new HashSet<>();
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursion(0, nums, new boolean[nums.length]);
        return answer;
    }
    
    private void recursion(int currIdx, int[] nums, boolean[] marked) {
        if(currIdx == nums.length) {
            StringBuilder strBuilder = new StringBuilder();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < marked.length; i++) {
                if(marked[i]) {
                    strBuilder.append(nums[i]);
                    temp.add(nums[i]);
                }
            }
            String checkStr = new String(strBuilder);
            if(!seen.contains(checkStr)) {
                answer.add(temp);
                seen.add(checkStr);
            }
            return;
        }
        
        else {
            // 1. mark currentIdx
            marked[currIdx] = true;
            recursion(currIdx + 1, nums, marked);
            // backTrack 
            marked[currIdx] = false;
            
            // 2. unmark currentIdx
            recursion(currIdx + 1, nums, marked);
        }
    }
}