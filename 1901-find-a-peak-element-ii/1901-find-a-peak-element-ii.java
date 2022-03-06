class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int midCol = cols / 2;
        
        int l = 0;
        
        int r = cols - 1;
        
        while( l <= r) {
            
            int mid = (l + r) / 2;
            
            int maxRowIdx = getMaxIdx(mat, mid);
            
            if(mid - 1 >= 0 && mat[maxRowIdx][mid-1] > mat[maxRowIdx][mid]) {
                r = mid; // look left
            } 
            else if(mid + 1 < cols && mat[maxRowIdx][mid+1] > mat[maxRowIdx][mid]) {
                l = mid + 1;
            }
            else {
                return new int[]{maxRowIdx, mid};
            }
        }
        
        return new int[]{};
        
    }
    
    private int getMaxIdx(int[][] mat, int col) {
        int maxVal = 0;
        int maxIdx = 0;
        for(int i = 0; i < mat.length; i++) {
            if(mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}