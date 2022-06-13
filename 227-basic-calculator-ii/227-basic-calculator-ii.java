class Solution {
    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();
        int currNumber = 0;
        int sign = 1;
        char prevOperator = '+';
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            
            if(Character.isDigit(currChar)) {
                currNumber = currNumber * 10 + (int) (currChar -'0');
            }
            
            if((!Character.isWhitespace(currChar) && !Character.isDigit(currChar)) || i == s.length() -1) {
                if(prevOperator == '+') {
                    st.add(currNumber);
                }
                else if(prevOperator =='-') {
                    st.add(-currNumber);
                }
                else if(prevOperator == '*') {
                    st.add(st.pop() * currNumber);
                }
                else if(prevOperator == '/') {
                    st.add(st.pop() / currNumber);
                }
                currNumber = 0;
                prevOperator = currChar;
            }   
        }
        
        int answer = 0;
        
        while(!st.isEmpty()) {
            answer += st.pop();
        }
        return answer;
    }
}