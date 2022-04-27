class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1: 3, 2:2, 3:1 -> 
        // 3 -> [1].    2->[2], 1 -> [3]
        
        //[1, 3], [2, 2], [3, 1]
        
        List<int[]> list = new ArrayList<>();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : nums) {
            if(!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
        }
        
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            list.add(new int[]{entry.getValue(), entry.getKey()});
        }
        
        Collections.sort(list, (int[] t1, int[] t2) -> {return t2[0]- t1[0];});
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = list.get(i)[1];
        }
        return ans;
    }
    
}