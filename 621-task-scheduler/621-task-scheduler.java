class Solution {
    public int leastInterval(char[] tasks, int n) {
        // t = 0
        // n = 2
        // pq = (A: 4), B: 3, 
        // q = A: 2, B: 3, 
        // pq = (4, 3)
        //
        // pq = 3, 3 t = 3
        // q = [(3,4), (2,5), ]
        int timeElapsed = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        
        int[] counts = new int[26];
        for(char task : tasks) counts[task - 'A']++;
        
        for(int count : counts) {
            if(count > 0) pq.add(count);
        }
        
        while(!pq.isEmpty() || !q.isEmpty()) {
            timeElapsed++;
            
            if(!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if(val > 0) q.add(new Pair<Integer, Integer>(val, timeElapsed + n));
            }
            
            if(!q.isEmpty() && q.peek().getValue() == timeElapsed) {
                pq.add(q.poll().getKey());
            }
        }
        
        return timeElapsed;
    }
}