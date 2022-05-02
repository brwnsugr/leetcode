class Solution {
    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        
        //[2,3,-2,4, -5]
        // Let smallest consecutive subarray where its product of elements is smallest til til i'th index
        // smallestSoFar[i] 
        // largestSoFar[i] 
        //
        //.    nums = [2, 3, -2,  4,  -5]
        // smallest = [2, 3, -12, -48, -5]
        // biggest =  [2, 6, -2, 4, 240]
        // in each index, biggest[i] = Math.max(biggest[i-1] * nums[i], smallest[i-1] * nums[i], nums[i]);
        // in each index, smallest[i] = Math.min(smallest[i-1] * nums[i], biggest[i-1], nums[i], nums[i]);
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        
        int[] biggestSoFar = new int[len];
        int[] smallestSoFar = new int[len];
        
        //initialize the starting value at biggest and smallest so far
        biggestSoFar[0] = nums[0];
        smallestSoFar[0] = nums[0];
        answer = nums[0];
        //[1,-1], curr = -1, big[1] = 1 * -1, -1, 1
        for(int i = 1; i < len; i++) {
            int currNumber = nums[i]; // curr = -1
            biggestSoFar[i] = Math.max(currNumber, Math.max(biggestSoFar[i-1]*currNumber, smallestSoFar[i-1]*currNumber));
            smallestSoFar[i] = Math.min(currNumber, Math.min(smallestSoFar[i-1]*currNumber, biggestSoFar[i-1]*currNumber));
            answer = Math.max(biggestSoFar[i], answer);
        }
                                       
        return answer;
    }
}