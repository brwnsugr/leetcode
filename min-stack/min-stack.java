class MinStack {

  private List<Integer> list;

  public MinStack() {
    list = new LinkedList<>();
  }

  public void push(int val) {
    list.add(val);
  }

  public void pop() {
    if(list.size() == 0) return;
    list.remove(list.size()-1);
  }

  public int top() {
    return list.get(list.size()-1);
  }

  public int getMin() {
    int min = Integer.MAX_VALUE;
    for(int i : list) {
      min = Math.min(min, i);
    }
    return min;
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