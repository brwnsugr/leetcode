class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty() && nums2[i] > st.peek()) {
                m.put(st.peek(), nums2[i]);
                st.pop();
            }
            
            st.add(nums2[i]);
        }
        
        while(!st.isEmpty()) {
            m.put(st.peek(), -1);
            st.pop();
        }
        
        int[] answer = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++) {
            answer[i] = m.get(nums1[i]);
        }
        
        return answer;
    }
}