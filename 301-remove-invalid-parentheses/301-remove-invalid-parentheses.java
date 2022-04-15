class Solution {
    
    private String input;
    private int minRemovedCount = Integer.MAX_VALUE;
    private Set<String> validSet = new HashSet<>();
    
    public List<String> removeInvalidParentheses(String s) {

        int mismatchLefts = 0;
        int mismatchRights = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if(stack.isEmpty()) stack.add(currChar);
            else if(currChar == '('){
                stack.add(currChar);
            }
            else if(currChar == ')') {
                if(stack.peek() == '(') stack.pop();
                else stack.add(currChar);
            }
        }
        
        while(!stack.isEmpty()) {
            if(stack.pop() == '(') mismatchLefts++;
            else mismatchRights++;
        }
        
        input = s;
        
        recursive(0, "", 0, 0, 0);
        return new ArrayList<>(validSet);
    }
    
    private void recursive(int idx, String exp, int removedCount, int leftCount, int rightCount) {
        if(idx == input.length()) {
            if(leftCount == rightCount && removedCount < minRemovedCount) {
                minRemovedCount = removedCount;
                validSet.clear();
                validSet.add(new String(exp));
            } else if(leftCount == rightCount && removedCount == minRemovedCount) {
                validSet.add(new String(exp));
            } 
            return;
        }
        char currChar = input.charAt(idx);
        
        if(currChar == '(') {
            recursive(idx+1, exp + currChar, removedCount, leftCount+1, rightCount);
            recursive(idx+1, exp, removedCount +1, leftCount, rightCount);
        }
        else if(currChar == ')') {
            recursive(idx+1, exp, removedCount +1, leftCount, rightCount);
            if(rightCount < leftCount) {
                recursive(idx+1, exp + currChar, removedCount, leftCount, rightCount + 1);
            }
        }
        
        else {
            recursive(idx+1, exp + currChar, removedCount, leftCount, rightCount);
        }
    }
    

}