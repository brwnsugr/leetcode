class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //nums = {1,3,4,5};  target = 9, return new int[]{2,3};
        
        //complement target = 9 -> 2의 comp -> 7, 
        
        Map<Integer, Integer> m = new HashMap<>(); // key 값에는 보수가 되기 위한 first idx, value = 보수를 넣는
        // nums.le
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            m.put(complement,i);
            // 0 -> 7, 1 -> 2, 2 -> -2, 3-> -6
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i]) && m.get(nums[i]) != i) {
                return new int[]{i, m.get(nums[i])};
            }
        }
        return new int[]{};
    }
}