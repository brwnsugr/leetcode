class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [1,2], [1,3] [2,3]
        // 
        // (   )
        //(  ) //
        Stack<int[]> st = new Stack<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        for(int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            if(!st.isEmpty() && st.peek()[1] > currStart) {
                if(currEnd < st.peek()[1]) {
                    st.pop();
                    st.add(new int[]{currStart, currEnd});
                }
            }
            else {
                st.add(new int[]{currStart, currEnd});
            }
        }
        
        return intervals.length - st.size();
    }
}