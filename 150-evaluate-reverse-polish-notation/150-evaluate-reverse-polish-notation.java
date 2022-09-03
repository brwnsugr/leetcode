class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        Stack<Integer> st = new Stack<>();
        
        for(String token : tokens) {
            if(token.matches("[+-]?[0-9]+")) {
                st.add(Integer.valueOf(token));
            }
            else {
                int lastNum = Integer.valueOf(st.pop());
                // int firstNum = Integer.valueOf(st.pop());
                int newNum = 0;
                if(token.equals("+")) {
                    newNum = st.peek() + lastNum;
                }
                else if(token.equals("-")) {
                    newNum = st.peek() - lastNum;
                }
                else if(token.equals("*")) {
                    newNum = st.peek() * lastNum;
                }
                else if(token.equals("/")) {
                    newNum = st.peek() / lastNum;
                }
                st.pop();
                st.add(newNum);
            }
        }
        return st.peek();
    }
}