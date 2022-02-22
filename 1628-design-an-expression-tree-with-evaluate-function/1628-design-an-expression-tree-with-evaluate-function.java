/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class TreeNode extends Node {
    
    private final String OPERATIONS = "+-*/";
    
    String val;
    TreeNode root;
    TreeNode left;
    TreeNode right;
    
    public int evaluate() {
        int res = dfs(this);
        return res;
    }
    
    private int dfs(TreeNode curr) {
        if(OPERATIONS.contains(curr.val)) {
            int left = dfs(curr.left);
            int right = dfs(curr.right);
            if(curr.val.equals("+")) return left + right;
            else if(curr.val.equals("-")) return left - right;
            else if(curr.val.equals("*")) return left * right;
            else return left / right;
        }
        else return Integer.parseInt(curr.val);
    }
    
    public TreeNode(String val) {
        this.val = val;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    
    private final String OPERATIONS = "+-*/";
    
    Node buildTree(String[] postfix) {
        TreeNode curr;
        Stack<TreeNode> s = new Stack<>();
        for(String item : postfix) {
            if(OPERATIONS.contains(item)) {
                curr = new TreeNode(item);
                curr.right = s.pop();
                curr.left = s.pop();
                s.add(curr);
            }
            else {
                s.add(new TreeNode(item));
            }
        }
        
        return s.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */