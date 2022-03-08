class Solution {
    public int findTheWinner(int n, int k) {
        
        /** k=2               
        queue q = [3];  qSize = 5
        
        */
        Queue<Integer> q = new LinkedList<>();
        
        //enqueue all the elements
        
        for(int i = 1; i <= n; i++) q.add(i);
        int counter = 0;
        while(q.size() != 1) {
            int curr = q.poll();
            counter++;
            if(counter == k) {
                counter = 0;
                continue;
            }
            q.add(curr);
        }
        
        int ret = q.poll();
        return ret;
    }
}