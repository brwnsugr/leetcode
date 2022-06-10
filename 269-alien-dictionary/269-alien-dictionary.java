class Solution {
    private Map<Character, List<Character>> adjMap = new HashMap<>();
    private Map<Character, Integer> inDegrees = new HashMap<>();
    private boolean dictValid = true;
    
    public String alienOrder(String[] words) {
        if(words.length == 1) return getRemovedDuplicatedWord(words[0]);
        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegrees.put(c, 0);
                adjMap.put(c, new ArrayList<>());
            }
        }
        
        initializeGraph(words);
        if(!dictValid) return "";
        
        
        // construct inDegree Count
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if(entry.getValue() == 0) q.add(entry.getKey());
        }
        StringBuilder strBuilder = new StringBuilder();
        while(!q.isEmpty()) {
            char curr = q.poll();
            
            for(char neighbor : adjMap.get(curr)) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) -1);
                if(inDegrees.get(neighbor) == 0) q.add(neighbor);
            }
            strBuilder.append(curr);
        }
        
        return inDegrees.size() == strBuilder.length() ? new String(strBuilder) : "";
    }
    
    
    private void initializeGraph(String[] words) {
        
        
        for(int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i+1];
            if(currWord.length() > nextWord.length() && currWord.startsWith(nextWord)) {
                dictValid = false;
                return;
            }
            int firstDiffIdx = 0;
            while(firstDiffIdx < currWord.length() && firstDiffIdx < nextWord.length()
                 && currWord.charAt(firstDiffIdx) == nextWord.charAt(firstDiffIdx)) {
                firstDiffIdx++;
            }
            
            // construct directed edge
            if(firstDiffIdx < currWord.length() && firstDiffIdx < nextWord.length()) {
                adjMap.get(currWord.charAt(firstDiffIdx)).add(nextWord.charAt(firstDiffIdx));
                inDegrees.put(nextWord.charAt(firstDiffIdx), inDegrees.getOrDefault(nextWord.charAt(firstDiffIdx), 0) + 1);
            }
            
            
        }
        
        
    }
    
    private String getRemovedDuplicatedWord(String word) {
        StringBuilder strBuilder = new StringBuilder();
        char[] arr = word.toCharArray();
        boolean[] visited = new boolean[26];
        for(char c : arr) {
            if(visited[c-'a']) continue;
            strBuilder.append(c);
            visited[c-'a'] = true;
        }
        return new String(strBuilder);
    }
}





// t->f,  w->e, r->t, e->r
// 