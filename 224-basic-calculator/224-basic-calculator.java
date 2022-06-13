class Solution {
    public int calculate(String s) {
        // "111 +" // operand = opernad times signs
        Stack<Integer> st = new Stack<>();
        
        // 1-5+4 = 1-5+4 = 0, -5. '+' next sign= 1. 
        // st = [4]
        // accuummulatedSum + (sign ) * st.peek() 
        // answer = 1. 
        // result = 4x, sign = 1  = 
        //(4x +( 4) answer += answer + sign * previous Result
        
        int operand = 0;
        int result = 0;
        int sign = 1;
        
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                operand = operand * 10 + (int) (currChar - '0');
            }
            
            else if(currChar == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            }
            
            else if(currChar == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            }
            else if(currChar == '(') {
                st.add(result);
                st.add(sign);
                operand = 0;
                result = 0;
                sign = 1;
            }
            else if(currChar == ')') {
                result += sign * operand;
                result *= st.pop();
                result += st.pop();
                sign = 1;
                operand = 0;
            }
        }
        int lastAdd = sign*operand;
        result += lastAdd;
        return result;
    }
}