class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        
        for(String token : tokens) {
            st.add(token);
            if(!isDigit(st.peek())) {
                String op = st.pop();
                int second = Integer.parseInt(st.pop());
                int first = Integer.parseInt(st.pop());
                if(op.equals("+")) {
                    st.add(String.valueOf(first + second));
                }
                else if(op.equals("-")) {
                    st.add(String.valueOf(first-second));
                }
                else if(op.equals("/")) {
                    st.add(String.valueOf(first / second));
                }
                else {
                    st.add(String.valueOf(first * second));
                }
            }
        }
        
        return Integer.parseInt(st.pop());
    }
    
    
    private boolean isDigit(String s) {
        if(s.length() > 1) return true;
        char c = s.charAt(0);
        return Character.isDigit(c);
    }
}