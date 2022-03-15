class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int totalCounts = matrix.length * matrix[0].length;
        int count = 0;
        int upSide = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        int downSide = matrix.length - 1;
        
        List<Integer> answer = new ArrayList<>();
        while(answer.size() < totalCounts) {
            
            
            //move right
            for(int col = left; col <= right; col++) {
                answer.add(matrix[upSide][col]);
            }
            upSide++;
            if (answer.size() >= totalCounts) break; 
            //move down
            for(int row = upSide; row <= downSide; row++) {
                answer.add(matrix[row][right]);
            }
            right--;
            if (answer.size() >= totalCounts) break; 
            //move left
            for(int col = right; col >= left; col--) {
                answer.add(matrix[downSide][col]);
            }
            downSide--;
            if (answer.size() >= totalCounts) break; 
            
            
            //move up
            for(int row = downSide; row >= upSide; row--) {
                answer.add(matrix[row][left]);
            }
            left++;
            if (answer.size() >= totalCounts) break; 
        }
        return answer;
    }
}