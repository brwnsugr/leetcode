class Solution {
    
    private boolean visited = false;
    private int answer;
    private int[] moves;
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        
        q.add(1);
        visited[1] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int curr = q.poll();
                if(curr == n * n) return steps;
                for(int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if(next > n * n) continue;
                    if(!visited[next]) {
                        visited[next] = true;
                        int dest = getDest(next, board);
                        if(dest == -1) {
                            q.add(next);
                        }
                        else {
                            q.add(dest);
                        }
                        
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    
    private int getDest(int curr, int[][] board) {
        int n = board.length; 
        int y = (curr - 1) / n;
        int x = 0;
        if(y % 2 == 0) x = curr - 1 - y*n;
        else x = n - (curr - y*n);
        return board[n - y - 1][x];
    }
    
    
}