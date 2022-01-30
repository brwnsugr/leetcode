class Solution {
  public int lengthOfLongestSubstring(String s) {
    if(s.length() <= 1) return s.length();

    int anchor = 0;
    int ans = 0;

    Map<Character, Integer> m = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      if(!m.containsKey(s.charAt(i))) {
        m.put(s.charAt(i), i);
      }
      else {
        if(anchor <= m.get(s.charAt(i))) {
          int len = i - anchor;
          ans = Math.max(ans, len);
          anchor = m.get(s.charAt(i))+1;
        }
        m.put(s.charAt(i), i);
      }
    }
    ans = Math.max(ans, s.length() - anchor);
    return ans;
  }
}