class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    /**
     * Naive Approach
     * from the start word, we traverse the next word that differs by a single letter
     * and do it recursively while we wouldn't get to the next anymore.
     * and we if we could visit all, put into this words in order as one of the answers list.
     *
     * Implementation Idea
     * 'dog' -> 'dot', 'hog'
     * 'dot' -> 'hot', 'bot'
     * Map key: word,  value: List of Adjacent Words of word as key
     *
     * 1. building up adjListMap
     * 2. Traversing it By short distance words first  a->[b,c] -> d
     * a -> b-> c (x) a->b
     *                   c->d
     * & mark each as visited.
     *
     * TC: build adjMap -> O(N^2) (try to generate all the pairs of it)
     * traverse it : O(N*N) SC: O(N*N)
     */

    wordList.add(beginWord);
    Map<String, List<String>> adjMap = new HashMap<>();
    for(String word : wordList) adjMap.put(word, new ArrayList<>());

    /**
     * build up adj wordlist in this map value
     */

    for(int i = 0; i < wordList.size()-1; i++) {
      for(int j = i+1; j < wordList.size(); j++) {
        String firstWord = wordList.get(i);
        String secondWord = wordList.get(j);
        for(int k = 0; k < firstWord.length(); k++) {
          if(buildOneBlurredWord(firstWord, k)
              .equals(buildOneBlurredWord(secondWord, k))){
            adjMap.get(firstWord).add(secondWord);
            adjMap.get(secondWord).add(firstWord);
            break;
          }
        }
      }
    }

    /**
     * BFS
     */


    Set<List<String>> answerSet = new HashSet<>();
    Queue<List<String>> q = new LinkedList<>();

    List<String> curr = new ArrayList<>();
    curr.add(beginWord);
    q.add(curr);
    Set<String> visited = new HashSet<>();

    boolean foundEndWord = false;
    while(!q.isEmpty()) {
      int qSize = q.size();
      for(int i = 0; i < qSize; i++) {
        List<String> currList = q.poll();
        String lastWord = currList.get(currList.size()-1);
        visited.add(lastWord);
        if(lastWord.equals(endWord)) {
          answerSet.add(currList);
          foundEndWord = true;
        }
        List<String> adjWords = adjMap.get(lastWord);
        for(String adjWord: adjWords) {
          if(!visited.contains(adjWord)) {
            currList.add(adjWord);
            q.add(new ArrayList<>(currList));
            currList.remove(adjWord);
          }
        }
      }
      if(foundEndWord) break;
    }

    List<List<String>> answerList = new ArrayList<>();
    for(List<String> path : answerSet) {
      answerList.add(path);
    }
    return answerList;
  }

  private String buildOneBlurredWord(String input, int pos) {
    char[] chars = input.toCharArray();
    chars[pos] = '*';
    return new String(chars);
  }
}