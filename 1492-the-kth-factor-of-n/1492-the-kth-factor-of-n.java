class Solution {
    
    private int size;
    
    public int kthFactor(int n, int k) {
        // 15 ->
        // sqrt of 15 -> 3.xx  3
        //  1^,2^,3^, 15/1 = 15^, 15/2 = 7.5, 15 / 3 =5^  4,5,6,7,8,9,10,11,12,13,14,15 
        
        // 16 -> 16/d, d <= sqrt(16) = 4 
        // 16, -> 1,2,3,4, 16/1= 16, 16/2 = 8,
        // 1,2,3,4,8,16
        Queue<Integer> maxHeap = new PriorityQueue<>((t1, t2) -> t2 - t1);
        
        size = k;
        
        int r = (int) Math.sqrt(n);
        
        for(int i = 1; i < r + 1 ; i++) {
            if(n % i == 0) {
                //heap <- 1, 16^, 2^, 8^, 4
                maxHeap.add(i);
                if(maxHeap.size() > size) maxHeap.remove();
                if( i != n / i) {
                    maxHeap.add(n/i);
                    if(maxHeap.size() > size) maxHeap.remove();
                }
            }
        }
        
        return k == maxHeap.size() ? maxHeap.poll() : -1;
        
    }
}