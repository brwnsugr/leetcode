class Solution {
    
  Boolean cache[];
    
  public boolean wordBreak(String s, List<String> wordDict) {
    cache = new Boolean[s.length()];
    return traverse(s, 0, new HashSet<>(wordDict));
  }
  
  private boolean traverse(String s, int startIdx, Set<String> wordDict) {
    
    if(startIdx == s.length()) {
      return true;
    }
    if(cache[startIdx] != null) return cache[startIdx];
    for(int i = startIdx+1; i <= s.length(); i++) { 
      String subString = s.substring(startIdx, i);
      if(wordDict.contains(subString) && traverse(s, i, wordDict)) { // remaining portio
          // for remainig portion we cached cache[i] : remaining string starting from the ith idx. 
        return cache[startIdx] = true;
        // return true;
      }
    }
    return cache[startIdx] = false;
  }
}