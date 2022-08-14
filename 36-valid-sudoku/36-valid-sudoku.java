class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> boxMap = new HashMap<>();
        //init each map
        for(int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            boxMap.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if(curr == '.') continue;
                int currNumber = curr - '0';
                int rowIdx = i;
                int colIdx = j;
                int boxIdx = (i/3)*3 + j/3;
                
                if(rowMap.get(rowIdx).contains(currNumber) 
                    || colMap.get(colIdx).contains(currNumber)
                    || boxMap.get(boxIdx).contains(currNumber)) {
                    return false;
                }
                rowMap.get(rowIdx).add(currNumber);
                colMap.get(colIdx).add(currNumber);
                boxMap.get(boxIdx).add(currNumber);
            }
        }
        return true;
    }
}