class Solution {
  Map<Character, List<Character>> adjList = new HashMap<>();
  Map<Character, Integer> counts = new HashMap<>();

  public String alienOrder(String[] words) {

    //cut edge case
    if(words.length == 1)
      return removeDuplicate(words[0]);


    //init adjList by empty list
    for(String word : words) {
      for(char c : word.toCharArray()) {
        adjList.put(c, new ArrayList<>());
        counts.put(c, 0);
      }
    }

    //build up graph (inDegree for each vertex, and init adjList of these)
    if(!buildUpGraph(words)) return "";

    StringBuilder sb = new StringBuilder();

    Queue<Character> q = new LinkedList<>();

    for(Character c : counts.keySet()) {
      if(counts.get(c) == 0) q.add(c);
    }

    while(!q.isEmpty()) {
      Character curr = q.remove();
      sb.append(curr);

      for(Character next : adjList.get(curr)) {
        counts.put(next, counts.get(next) -1);
        if(counts.get(next) == 0) q.add(next);
      }
    }

    return sb.length() == counts.size() ? sb.toString() : "";
  }


  private boolean buildUpGraph(String[] words) {
    for(int i = 0; i < words.length-1; i++) {
      //compare adj pair -> put pair of character where occurs first difference
      if(words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])) return false;

      int firstDiffIdx = 0;
      while(firstDiffIdx < words[i].length()
          && firstDiffIdx < words[i+1].length()
          && words[i].charAt(firstDiffIdx) == words[i+1].charAt(firstDiffIdx)) {
        firstDiffIdx++;
      }

      if(firstDiffIdx < words[i].length() && firstDiffIdx < words[i+1].length()) {
        adjList.get(words[i].charAt(firstDiffIdx)).add(words[i+1].charAt(firstDiffIdx));
        counts.put(words[i+1].charAt(firstDiffIdx), counts.get(words[i+1].charAt(firstDiffIdx)) + 1);
      }
    }
    return true;
  }

  private String removeDuplicate(String input) {
    Set<Character> s = new HashSet<>();
    StringBuilder strBuilder = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
      if(s.contains(input.charAt(i))) continue;
      else {
        strBuilder.append(input.charAt(i));
        s.add(input.charAt(i));
      }
    }
    return strBuilder.toString();
  }
}