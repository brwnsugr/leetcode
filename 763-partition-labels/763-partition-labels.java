class Solution {
  public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];

    for(int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }
    
    int start = 0;
    int end = 0;
    List<Integer> ret = new ArrayList<>();
    for(int i = 0; i < s.length(); i++) {
      end = Math.max(end, last[s.charAt(i) -'a']);
      if(i == end) {
        ret.add(end - start + 1);
        start = end + 1;
      }
    }
    return ret;
  }
}