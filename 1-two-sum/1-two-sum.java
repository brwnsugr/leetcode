class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i]) && m.get(nums[i]) != i) {
                return new int[]{m.get(nums[i]), i};
            }
            m.put(target-nums[i], i);
        }
        return new int[]{};
    }
}