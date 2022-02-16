class Solution {
    public int minSwaps(int[] data) {
        
        int ones = Arrays.stream(data).sum();
        
    
        
        int cntOne = 0, maxOne = 0;
        int left = 0, right = 0;
        
        while(right < data.length) {
            cntOne += data[right++];
            
            if(right - left > ones) {
                cntOne -= data[left++];
            }
            
            maxOne = Math.max(maxOne, cntOne);
        }
        return ones - maxOne;
        
    }
}