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
        
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> countMap.get(n1) - countMap.get(n2));
        
        for(int key : countMap.keySet()) {
            pq.add(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
    
}