class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        //enqueue all the elements
        for(int i = 1; i <= n; i++) q.add(i);
        
        int counter = 0;
        while(q.size() != 1) {
            int curr = q.poll();
            counter++;
            if(counter == k) { // when counter meets k'th, we reset counter and would not enqueue this elements.
                counter = 0;
            }
            else q.add(curr);
        }
        
        int ret = q.poll();
        return ret;
    }
}