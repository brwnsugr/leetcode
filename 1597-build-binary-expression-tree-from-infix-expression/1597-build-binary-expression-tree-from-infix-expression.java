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
    
    private int idx = 0;
    
    public Node expTree(String s) {
        String ret = convertToPrefix(s);
        StringBuffer strBuffer = new StringBuffer(ret);
        String reverseStr = strBuffer.reverse().toString();
        return createNode(reverseStr);
    }
    
    private Node createNode(String str) {
        char curr = str.charAt(idx++);
        Node node = new Node(curr);
        if(curr == '+' || curr =='-' || curr == '*' || curr == '/') {
            node.right = createNode(str);
            node.left = createNode(str);
        }
        return node;
    }
    
    private String convertToPrefix(String infix) {
        StringBuilder strBuilder = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for(char c : infix.toCharArray()) {
            if(c == '(') st.add(c);
            else if(c == ')') {
                while(st.peek() != '(') {
                    strBuilder.append(st.pop());
                }
                st.pop();
            }
            else if(c == '*' || c == '/' || c == '+' || c == '-') {
                while(!st.isEmpty() && st.peek() != '(' && getPrecedence(c) <= getPrecedence(st.peek()))
                    strBuilder.append(st.pop());
                st.add(c);
            }
            else {
                strBuilder.append(c);
            }
        }
        while(!st.isEmpty()) {
            strBuilder.append(st.pop());
        }
        
        return new String(strBuilder);
    }
    
    private int getPrecedence(char c) {
        if(c == '*' || c == '/') return 2;
        else  return 1;
    }
}