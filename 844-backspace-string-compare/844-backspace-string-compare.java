class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        return buildStr(s).equals(buildStr(t));
    }
    
    private String buildStr(String input) {
        Stack<Character> st = new Stack<>();
        
        for(char c : input.toCharArray()) {
            if(c != '#') {
                st.add(c);
            }
            else {
                if(!st.isEmpty()) st.pop();
            }
        }
        
        return String.valueOf(st);
    }
}