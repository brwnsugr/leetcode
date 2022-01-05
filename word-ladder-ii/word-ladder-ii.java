class Solution {
  List<List<String>> answer = new ArrayList<>();
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    if(wordList.size() == 1) {
      if(endWord.equals(wordList.get(0))) {
        answer.add(Arrays.asList(endWord));
        return answer;
      }
      return answer;
    }
    if(!wordList.contains(beginWord)) wordList.add(beginWord);
    Map<String, List<String>> adjMap = new HashMap<>();
    int wordLen = wordList.get(0).length();

    for(int i = 0; i < wordList.size(); i++) {
      for(int j = 0; j < wordLen; j++) {
        String proto = makeProto(wordList.get(i), j);
        if(!adjMap.containsKey(proto)) adjMap.put(proto, new ArrayList<>());
        adjMap.get(proto).add(wordList.get(i));
      }
    }

    bfs(adjMap, beginWord, endWord);
    return answer;
  }
  
  private void bfs(Map<String, List<String>> adjMap, String beginWord, String target) {
    Set<String> visited = new HashSet<>();
    Queue<List<String>> q = new LinkedList<>();
    
    List<String> path = new ArrayList<>();
    
    path.add(beginWord);
    boolean found = false;
    q.add(path);
    
    while(!q.isEmpty() && !found) {
      int count = q.size();
      for(int i = 0; i < count; i++) {
        List<String> currPath = q.poll();
        if(currPath.get(currPath.size() -1).equals(target)) {
          found = true;
          answer.add(new ArrayList<>(currPath));
        }
        String currWord = currPath.get(currPath.size()-1);
        visited.add(currWord);
        for(int j = 0; j < currWord.length(); j++) {
          String proto = makeProto(currWord, j);
          List<String> nextWords = adjMap.get(proto);
          for(String nextWord : nextWords) {
            if(!visited.contains(nextWord)) {
              currPath.add(nextWord);
              q.add(new ArrayList<>(currPath));
              currPath.remove(nextWord);
            }
          }
        }
      }
    }
  }

  public String makeProto(String word, int idx){
    return word.substring(0,idx) + "*" + word.substring(idx+1);
  }
}