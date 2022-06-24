/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int i = 0;
    public Node expTree(String s) {
        // convert infixx operation s -> postfix 
        String postfix = convertToPostfix(s);
        StringBuffer sb = new StringBuffer(postfix);
        String reversedStr = sb.reverse().toString();
        
//         Node root = new Node(reversedStr.charAt(0));
//         Node curr = root;
        return createTree(reversedStr);
    }
    
    private Node createTree(String s) {
        char c = s.charAt(i++);
        Node node = new Node(c);
        
        if( c == '+' || c == '-' || c == '*' || c =='/') {
            if(node.right == null) {
                node.right = createTree(s);
            }
            if(node.left == null) {
                node.left = createTree(s);
            }
        }
        return node;
    }
    
//     private void reverse(String input) {
//         int len = input.length();
//         for(int i = 0; i < len/2; i++) {
            
//         }
//     }
    
    private String convertToPostfix(String infix) {
        StringBuilder strBuilder = new StringBuilder(); 
        Stack<Character> st = new Stack<>();
        Map<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('+', 1);
        scoreMap.put('-', 1);
        scoreMap.put('*', 2);
        scoreMap.put('/', 2);
        for(char c : infix.toCharArray()) {
            if(Character.isDigit(c)) strBuilder.append(c);
            else if(c == '(') st.add(c);
            else if(c == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    char p = st.pop();
                    strBuilder.append(p); 
                }
                    
                st.pop();
            }
            // else {
            //     if(st.isEmpty()) st.add(c);
            //     else if(st.peek() != '(' && scoreMap.get(c) > scoreMap.get(st.peek())){
            //         st.add(c);
            //     }
            //     else {
            //         strBuilder.append(st.pop());
            //         st.add(c);
            //     }
            // }
            else{
                while(!st.isEmpty() && scoreMap.containsKey(st.peek()) && scoreMap.get(c) <= scoreMap.get(st.peek())) {
                    strBuilder.append(st.pop());
                }
                st.add(c);
            }
        }
        
        while(!st.isEmpty()) {
            strBuilder.append(st.pop());
        }
        return new String(strBuilder);
    }
}