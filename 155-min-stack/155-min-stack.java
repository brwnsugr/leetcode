class MinStack {
    
    private int minVal;
    private Stack<Node> st;
    public MinStack() {
        this.st = new Stack<>();
    }
    
    public void push(int val) {
        // st.add(val);
        if(!st.isEmpty()) {
            if(st.peek().minVal < val) {
                st.add(new Node(val, st.peek().minVal));
            } else {
                st.add(new Node(val, val));
            }
        }
        else {
            st.add(new Node(val, val));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minVal;
    }
}

class Node {
    int minVal;
    int val;
    
    public Node(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */