class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //Ranging Cache 
        //[0,0,0,0,0] [[0,2,1]]
        //[1,0,0,-1,0]
        
        
        // res = res + arr[4]; 
        // [1,1,1,0,0]
        
        int[] arr = new int[length];
        
        for(int[] update : updates) {
            arr[update[0]] += update[2];
            if(update[1] < length - 1) {
                arr[update[1]+1] -= update[2];
            }
        }
        
        int res = 0;
        for(int i = 0; i < length; i++) {
            res += arr[i];
            arr[i] = res;
        }
        
        return arr;
    }
}