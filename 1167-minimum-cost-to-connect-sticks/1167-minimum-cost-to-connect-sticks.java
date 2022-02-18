class Solution {
    public int connectSticks(int[] sticks) {
        Arrays.sort(sticks);
        /*
        [2,4,3]
        -> [2,3,4]
        
        2+3, 2+3+4
        
         3  3  2  1
        [1,2,3,4]
        1+2, 1+2+3, 1+2+3+4
    
        [31,63,80,90]
        31+63
        31+63+80
        31+63+80+90
        
        93+189+250
        
        282+250 = 532
        
        94 -> [80,90,94]
        
        80 + 90 ->[94, 170]
        
        170 + 94
        
        258+174
         = 358 + 170 = 528
        */
        if(sticks.length == 1) return 0;
        
        int totalCost = 0;
        int len = sticks.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : sticks) pq.add(num);
        
        while(pq.size() != 1) {
            int first = pq.remove();
            int second = pq.remove();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);
        }
        
        
        return totalCost;
    }
}