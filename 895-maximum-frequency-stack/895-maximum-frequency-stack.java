class FreqStack {

  Map<Integer, Integer> freqMap;
  Map<Integer, Stack<Integer>> maxFreqMap;
  int maxFreq;

  public FreqStack() {
    freqMap = new HashMap<>();
    maxFreqMap = new HashMap<>();
    maxFreq = 0;
  }

  public void push(int val) {
    freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
    int currFreq = freqMap.get(val);
    if(currFreq > maxFreq) maxFreq = currFreq;

    if(!maxFreqMap.containsKey(currFreq)) maxFreqMap.put(currFreq, new Stack<>());
    maxFreqMap.get(currFreq).push(val);
  }

  public int pop() {
    int ret = maxFreqMap.get(maxFreq).pop();    
    freqMap.put(ret, freqMap.get(ret) - 1);
    if(maxFreqMap.get(maxFreq).isEmpty()) maxFreq--;
    return ret;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */