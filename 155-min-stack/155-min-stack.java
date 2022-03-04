

class MinStack {
    
    List<Node> list;

    public MinStack() {
        list = new LinkedList<>();
    }
    
    public void push(int val) {
        if(list.size() == 0) {
            list.add(new Node(val, val));
        }
        else {
            Node prev = list.get(list.size()-1);
            int minVal = Math.min(prev.minVal, val);
            list.add(new Node(val, minVal));
        }
        
    }
    
    public void pop() { //    S = ( (v: 10, m: 10), (v: ^4, m :4), (v: ^3, m: 3^)) -> 
        list.remove(list.size()-1);
    }
    
    public int top() {
        Node ret = list.get(list.size()-1);
        return ret.val;
    }
    
    public int getMin() {
        return list.get(list.size()-1).minVal;
    }
    
    static class Node {
        int val;
        int minVal;
        
        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
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