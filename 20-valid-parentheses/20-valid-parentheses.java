class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');
        Stack<Character> st = new Stack<>();
        // s= {, }
        for(char c : s.toCharArray()) {
            if(parenthesesMap.containsKey(c)) {
                if(!st.isEmpty() && st.peek() == parenthesesMap.get(c)) {
                    st.pop();
                }
                else return false;
            }
            else st.add(c);
        }
        
        return st.isEmpty();
    }
}