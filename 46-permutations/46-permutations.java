class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        recursion(nums, new HashSet<>(), new ArrayList<>());
        return answer;
    }
    
    
    private void recursion(int[] nums, Set<Integer> visited, List<Integer> tempList) {
        if(visited.size() == nums.length) {
            answer.add(new ArrayList<>(tempList));
            return;
        }
        
        else {
            for(int i = 0; i < nums.length; i++) {
                if(!visited.contains(nums[i])) {
                    visited.add(nums[i]);
                    tempList.add(nums[i]);
                    recursion(nums, visited, tempList);
                    visited.remove(nums[i]);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}