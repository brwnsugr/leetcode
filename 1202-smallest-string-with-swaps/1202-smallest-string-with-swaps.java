class Solution {
    
    private static final int N = 100001;
    private boolean[] visited = new boolean[N+1];
    private List<Integer>[] adjList = new ArrayList[N]; 
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        
        //init adjList
        for(int i = 0; i < s.length(); i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(List<Integer> pair : pairs) {
            adjList[pair.get(0)].add(pair.get(1));
            adjList[pair.get(1)].add(pair.get(0));
        }
        
        char[] answerList = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(!visited[i]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                dfs(characters, indices, i, s);
                
                Collections.sort(characters);
                Collections.sort(indices);
                for(int j = 0; j < indices.size(); j++) {
                    answerList[indices.get(j)] = characters.get(j);
                }
            }
        }
        
        return new String(answerList);
    }
    
    
    private void dfs(List<Character> characters, List<Integer> indices, int vertex, String s) {
        characters.add(s.charAt(vertex));
        indices.add(vertex);
        visited[vertex] = true;
        
        for(int neighbor : adjList[vertex]) {
            if(!visited[neighbor]) dfs(characters, indices, neighbor, s);
        }
        
        
    }
}