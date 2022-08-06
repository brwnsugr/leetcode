class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;
        
        int steps = 0;
        for(int i = 0; i < moves.length; i++) {
            steps++;
            int currR = moves[i][0];
            int currC = moves[i][1];
            
            if(i % 2 == 0) { // A
                rows[currR]++;
                cols[currC]++;
                if(currR == currC) diagonal++;
                if(Math.abs(currR - currC) == 2 || currR * currC == 1) antiDiagonal++;
            }
            else if(i % 2 == 1){ // B
                rows[currR]--;
                cols[currC]--;
                if(currR == currC) diagonal--;
                if(Math.abs(currR - currC) == 2 || currR * currC == 1) antiDiagonal--;
            }

            if(rows[currR] == 3 
              || cols[currC] == 3 
              || diagonal == 3 || antiDiagonal == 3) return "A";
            
            if(rows[currR] == -3 
              || cols[currC] == -3 
              || diagonal == -3 || antiDiagonal == -3) return "B";
        }
        
        return steps == 9 ? "Draw" : "Pending";
    }
}