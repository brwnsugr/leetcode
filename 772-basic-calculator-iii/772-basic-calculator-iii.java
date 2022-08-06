class Solution {
    public int calculate(String s) {
        int res = 0;
        
        char lastSign = '+';
        
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char curr = s.charAt(i);
            
            if(curr == '(') {
                int l = 1;
                int r = i + 1;
                while ( r < s.length() && l > 0) {
                    if(s.charAt(r) == '(') l++;
                    else if(s.charAt(r) == ')') l--;
                    r++;
                }
                int val = calculate(s.substring(i+1, r-1));
                i = r;
                if(lastSign == '+') {
                    st.add(val);
                }
                else if(lastSign == '-') {
                    st.add(-val);
                }
                else if(lastSign == '/') {
                    st.add(st.pop() / val);
                }
                else {
                    st.add(st.pop() * val);
                }
            }
            
            else if(Character.isDigit(curr)) {
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + s.charAt(i) - '0';
                    i++;
                }
                
                if(lastSign == '+') {
                    st.add(val);
                }
                else if(lastSign == '-') {
                    st.add(-val);
                }
                else if(lastSign == '/') {
                    st.add(st.pop() / val);
                }
                else {
                    st.add(st.pop() * val);
                }
            }
            
            else {
                lastSign = curr;
                i++;
            }
        }
        
        while(!st.isEmpty()) {
            res += st.pop();
        }
        
        return res;
    }
}