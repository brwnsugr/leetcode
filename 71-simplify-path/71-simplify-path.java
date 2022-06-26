class Solution {
    public String simplifyPath(String path) {
        // . -> just skip
        // 
        
        String[] tokens = path.split("/");
        
        Deque<String> st = new ArrayDeque<>();
        
        for(String token : tokens) {
            if(token.equals(".") || token.isEmpty()) continue;
            else if(token.equals("..")) {
                if(!st.isEmpty()) {
                    st.removeLast();
                }
            }
            else {
                st.addLast(token);
            }
        }
        
        
        String ans = "/";
        while(!st.isEmpty()) {
            ans += st.pollFirst();
            if(!st.isEmpty()) ans += "/";
        }
        
        return ans;
    }
}