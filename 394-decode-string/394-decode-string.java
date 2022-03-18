class Solution {
    public String decodeString(String s) {
        
        
        // 3[a]2[bc]
        // s = 5[ 3, [, a, ]]      aaa ->  if we meet ']' [ -> 5 
        //
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i <s.length(); i++) {
            List<Character> charList = new ArrayList<>();
            if(s.charAt(i) == ']') {
                // 닫히는 괄호를 만나게 되면, [
                //1. 열리는 괄호를 만날떄까지, stack에서 character 뽑아주면서 그거를 concat 해준다.(괄호안에 있는 문자열)
                while(stack.peek() != '[') {
                    charList.add(stack.pop());
                }
                
                stack.pop(); // 제일 위에 있는 열린괄호를 날려줌 333[
                
                //2. 닫히는 괄호의 바로 앞에 있는 숫자를 계산해서 해당 문자열을 숫자만큼 concat
                //숫자를 먼저 뽑아주고
                int number = 0;
                int base = 1;
                
                // stack = -> 4 + 30 + 200 + 1000
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number += (stack.pop() - '0') * base; // '3 - '0' -> 
                    base *= 10;
                }
                
                // 숫자만큼 charList 배열에 붙여줌
                // charList =['a','a'] 

                while(number > 0) {
                    for(int j = charList.size() -1; j >= 0; j--) {
                        stack.push(charList.get(j));
                    }
                    number--;
                }
            }
            else {
                stack.push(s.charAt(i));
            }
            
        }
        
        /// stack -> string
        char[] res = new char[stack.size()];
        for(int i = res.length -1 ; i>=0; i--) {
            res[i] = stack.pop();
        }
        
        String answer = new String(res);
        
        return answer;
        
    }
}