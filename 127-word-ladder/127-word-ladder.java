class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(!wordList.contains(endWord)) return 0;
    if(!wordList.contains(beginWord)) wordList.add(beginWord);
    int wordLen = wordList.get(0).length();
    Map<String, List<String>> adjMap = new HashMap<>();

    for(int i = 0; i < wordList.size(); i++) {
      for(int j = 0; j < wordLen; j++) {
        String proto = getProto(wordList.get(i), j);
        if(!adjMap.containsKey(proto)) adjMap.put(proto, new ArrayList<>());
        adjMap.get(proto).add(wordList.get(i));
      }
    }

    Set<String> visited = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    
    q.add(beginWord);
    boolean found = false;
    int pathCount = 0;
    while(!q.isEmpty() && !found) {
      
      int qSize = q.size();
      pathCount++;
      for(int i = 0; i < qSize; i++) {
        String currWord = q.poll();
        if(currWord.equals(endWord)) {
          found = true;
          break;
        }
        visited.add(currWord);
        for(int j = 0; j < wordLen; j++) {
          String proto = getProto(currWord, j);
          List<String> nextWords = adjMap.get(proto);
          for(String nextWord : nextWords) {
            if(!visited.contains(nextWord)) {
              q.add(nextWord);
            }
          }
        }
      }
    }
    return found ? pathCount : 0;
  }

  private String getProto(String word, int idx) {
    return word.substring(0,idx) + "*" + word.substring(idx+1);
  }
}