class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        
        boolean peakFound = false;
        
        boolean upWard = true;
        boolean hasIncreasingInterval = false;
        boolean hasDecreasingInterval = false;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) return false;
            else if(upWard) {
                if(arr[i] < arr[i-1]) {
                    upWard = false;
                    hasDecreasingInterval = true;
                }
                else hasIncreasingInterval = true;
            }
            else {
                if(arr[i] > arr[i-1]) return false;
                else hasDecreasingInterval = true;
            }
        }
        return hasIncreasingInterval && hasDecreasingInterval;
    }
}