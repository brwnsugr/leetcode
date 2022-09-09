class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int stone : stones) pq.add(stone);
        
        while(pq.size() > 1) {
            int heviestStone = pq.poll();
            int secondHeaviestStone = pq.poll();
            if(heviestStone > secondHeaviestStone) 
                pq.add(heviestStone - secondHeaviestStone);
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}