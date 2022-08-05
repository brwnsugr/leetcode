class Solution {
    
    private boolean visited = false;
    private int answer;
    private int[] moves;
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        moves = new int[n * n + 1];
        Arrays.fill(moves, Integer.MAX_VALUE);        
        moves[1] = 0;
        dfs(1, board);
        return moves[n*n] == Integer.MAX_VALUE ? -1 : moves[n*n];
    }
    
    private void dfs(int curr, int[][] board) {
        int n = board.length;
        for(int i = 1; i <= 6; i++) {
            int next = curr + i;
            if(next > n*n) continue;    
            int dest = getDest(next, board);
            
            if(dest == -1) {
                if(moves[next] > moves[curr] + 1) {
                    moves[next] = moves[curr] + 1;
                    dfs(next, board);
                }
            }
            else {
                if(moves[dest] > moves[curr] + 1) {
                    moves[dest] = moves[curr] + 1;
                    dfs(dest, board);
                }
            }
        }
        
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