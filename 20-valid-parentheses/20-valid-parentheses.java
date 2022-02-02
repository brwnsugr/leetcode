class Solution {
  public boolean isValid(String s) {
    /**
     * we use stack to store the open brackets
     *
     * we just put all the open brackets we would meet,
     * and in case we meet the close brackets
     *
     * check the peek of the stack and if it can be removed by the open bracket
     *
     * if it can not, return false
     * and if can, remove the peek of the stack and go to the next step til the string ends
     *
     * after the loop, return true if stack is empty , which means all the pair of brackets are valid
     * cuz all the pair of brackets removed.
     *
     * or not, return false.
     */

    Stack<Character> stack = new Stack<>();

    Set<Character> openBrackets = new HashSet<>();
    openBrackets.add('('); openBrackets.add('{'); openBrackets.add('[');
    Set<Character> closeBrackets = new HashSet<>();
    closeBrackets.add(')'); closeBrackets.add('}'); closeBrackets.add(']');
    
    for(char c : s.toCharArray()) {
      if(openBrackets.contains(c)) stack.add(c);
      else if(closeBrackets.contains(c) && !stack.isEmpty()) {
        char open = stack.peek();
        if((c == ')' && open=='(') || (c=='}' && open=='{') || (c==']' && open=='[')) stack.pop();
        else return false;
      }
      else return false;
    }
    return stack.isEmpty();
  }
}