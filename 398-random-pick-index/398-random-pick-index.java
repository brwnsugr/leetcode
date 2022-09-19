class Solution {
    
    private Map<Integer, List<Integer>> idxMap;
    private Random rand;
    
    public Solution(int[] nums) {
        rand = new Random();
        idxMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!idxMap.containsKey(nums[i])) idxMap.put(nums[i], new ArrayList<>());
            idxMap.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> idxArr = idxMap.get(target);
        int len = idxArr.size();
        return idxArr.get(rand.nextInt(len));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */