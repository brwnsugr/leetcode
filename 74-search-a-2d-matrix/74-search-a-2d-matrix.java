class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find right row first
        int row = findRow(matrix, target);
        //in the row find col
        if(row == matrix.length) return false;
        if(matrix[row][0] == target) return true;
        return existInRow(matrix, row, target);
    }
    
    private boolean existInRow(int[][] matrix, int row, int target) {
        int l = 0; 
        int r = matrix[0].length - 1;
        
        while(l <= r) {
            int mid = l + (r - l ) / 2;
            if(target < matrix[row][mid]) {
                r = mid - 1;
            }
            else if(target > matrix[row][mid]) {
                l = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    
    private int findRow(int[][] matrix, int target) {
        int l = 0; 
        int r = matrix.length;
        int mid = 0;
        int cols = matrix[0].length;
        while(l < r) {
            mid = l + (r-l) / 2;
            if(target > matrix[mid][cols - 1] ) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}