class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            if(num % 2 == 0) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            
            if(entry.getValue() > count) {
                count = entry.getValue();
                ans = entry.getKey();
            }
            else if(entry.getValue() == count) {
                if(entry.getKey() < ans) ans = entry.getKey();
            }
        }
        
        return ans;
    }
}