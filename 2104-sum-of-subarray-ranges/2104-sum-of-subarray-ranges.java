class Solution {
    public long subArrayRanges(int[] nums) {
        
        // [1,3,6]
        //arr = [1,3,3]
        //minFromI = [1,3,3]
        //maxTilI = [1,3,3]
        
        Stack<Integer> s = new Stack<>();
        int numLen = nums.length;
        long answer = 0;
        for(int i = 0; i <= numLen; i++) {
            while(!s.isEmpty() && (i == numLen || nums[s.peek()] < nums[i])) {
                int top = s.pop();
                int l = s.isEmpty() ? top + 1 : top - s.peek();
                int r = i - top;
                answer += (long) nums[top] * r * l;
            }
            s.add(i);
        }
        s.clear();
        for(int i = 0; i <= numLen; i++) {
            while(!s.isEmpty() && (i == numLen || nums[s.peek()] > nums[i])) {
                int top = s.pop();
                int l = s.isEmpty() ? top + 1 : top - s.peek();
                int r = i - top;
                answer -= (long) nums[top] * r * l;
            }
            s.add(i);
        }
        
        return answer;
    }
}