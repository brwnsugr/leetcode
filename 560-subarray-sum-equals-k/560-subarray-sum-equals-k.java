class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();
        
        m.put(0, 1); // m = [{0,1},{1,1},{2,1}], a = 1, 
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(m.containsKey(sum-k)) {
                answer += m.get(sum-k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        
        return answer;
        
    }
}