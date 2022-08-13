class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> decStack = new Stack<>();
        Stack<Integer> incStack = new Stack<>();
        long answer = 0;
        
        for(int i = 0; i <= nums.length; i++) {
            
            while(!decStack.isEmpty() && (i == nums.length || nums[decStack.peek()] < nums[i])) {
                int currIdx = decStack.pop();
                int leftBound = decStack.isEmpty() ? -1 : decStack.peek();
                int rightBound = i;
                answer += (long) ((rightBound - currIdx) * (currIdx - leftBound)) * nums[currIdx];
            }
            
            
            while(!incStack.isEmpty() && (i == nums.length || nums[incStack.peek()] > nums[i])) {
                int currIdx = incStack.pop();
                int leftBound = incStack.isEmpty() ? -1 : incStack.peek();
                int rightBound = i;
                answer -= (long) ((rightBound - currIdx) * (currIdx - leftBound)) * nums[currIdx];
            }
            
            
            decStack.add(i);
            incStack.add(i);
        }
        
        return answer;
        
    }
}