class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        
        int prev = -1; int next = 0;
        int answer = 0;
        
        
        for(int i = 0; i < N; i++) {
            if(seats[i] == 1) {
                prev = i;
            }
            
            else {
                while(next < N && seats[next] == 0 || next < i) next++;
                
                int leftOffset = prev == -1 ? N : i - prev;
                int rightOffset = next == N ? N : next - i;
                answer = Math.max(answer, Math.min(leftOffset, rightOffset));
                
            }
        }
        
        return answer;
    }
}