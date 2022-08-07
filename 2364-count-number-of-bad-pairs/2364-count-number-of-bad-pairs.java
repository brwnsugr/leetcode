class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return 0;
        long totalPairs = 0;

        // long N = 1L * (n-1);
        long N = (long) n;
        totalPairs = ((N * (N-1)) / 2);

        Map<Integer, Long> m = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            m.put(curr - i, 0L);
        }
        
        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i] - i, m.get(nums[i] - i) + 1);
        }
        
        long tmpGoods = 0;
        
        for(Map.Entry<Integer, Long> entry : m.entrySet()) {
            long goods = entry.getValue();
            tmpGoods += (goods * (goods -1))/2;
        }
        
        
        return totalPairs - tmpGoods;
    }
}