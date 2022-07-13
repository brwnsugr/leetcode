class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] answer = new int[n];
        
        Arrays.fill(answer, -1);
        answer[0] = 0;
        boolean[] visited = new boolean[n*2];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(null);
        
        int dist = 1;
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            if(curr == null) {
                if(!q.isEmpty()) {
                    dist++;
                    q.add(null);
                }
            }
            
            else if(!visited[n + curr]){
                visited[n+curr] = true;
                if(curr >= 0) {
                    for(int[] red : redEdges) {
                        if(curr == red[0]) {
                            if(answer[red[1]] == -1) {
                                answer[red[1]] = dist;
                            }
                            q.add(-red[1]);
                        }
                    }
                }
                
                if(curr <= 0) {
                    for(int[] blue : blueEdges) {
                        if(blue[0] == -curr) {
                            if(answer[blue[1]] == -1) {
                                answer[blue[1]] = dist;
                            }
                            q.add(blue[1]);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}