class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        
        /*
        0,0,0,0,0
        
        0,2,0,2,0
        0,2,3,2,3
        
       -2,2,1,2,3
        
        */
        int[] arr = new int[length];
        
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            for(int i = start; i <= end; i++) {
                arr[i] += value;
            }
        }
        return arr;
    }
}