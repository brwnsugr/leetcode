class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        int[] counts = new int[26];
        
        for(char task : tasks) counts[task - 'A']++;
        
        for(int count : counts) {
            if(count > 0 ) pq.add(count);
        }
        
        while(!pq.isEmpty() || !q.isEmpty()) {
            if(!pq.isEmpty()) {
                int topTask = pq.poll();
                topTask--;
                if(topTask > 0) {
                    q.add(new Pair<Integer,Integer>(topTask, time + n));
                }
            }
            
            if(!q.isEmpty() && q.peek().getValue() == time) {
                pq.add(q.poll().getKey());
            }
            time++;
        }
        
        return time;
    }
}