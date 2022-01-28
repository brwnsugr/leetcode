class Solution {
    public int[] twoSum(int[] nums, int target) {        
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(m.containsKey(nums[i])) {
                return new int[]{m.get(nums[i]), i};
            }
            m.put(complement, i);
        }
        return null;
    }
}