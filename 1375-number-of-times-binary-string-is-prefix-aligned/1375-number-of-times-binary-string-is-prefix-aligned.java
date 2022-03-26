class Solution {
    public int numTimesAllBlue(int[] flips) {
        //(rightmost idx of 1) + 1 = count of 1s 
        // 011000 rIdx = 2, count = 2
        // 111000 rIdx = 2 count = 3 -> prefix-aligned
        
        // TC: O(N) 
        
        int rightMostIdx = 0;
        int onesCount = 0;
        int prefixAlignedCount = 0;
        for(int i = 0; i < flips.length; i++) {
            rightMostIdx = Math.max(rightMostIdx, flips[i] - 1);
            onesCount++;
            if(rightMostIdx + 1 == onesCount) prefixAlignedCount++;
        }
        
        return prefixAlignedCount;
    }
}