class Solution {
  public int lengthOfLongestSubstring(String s) {
    if(s.length() <= 1) return s.length();

    int anchor = -1;
    int ans = 0;

    Map<Character, Integer> m = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      if(m.containsKey(s.charAt(i))
          && anchor < m.get(s.charAt(i))) {
        anchor = m.get(s.charAt(i));
      }
      m.put(s.charAt(i), i);
      ans = Math.max(ans, i - anchor);
    }
    return ans;
  }
}