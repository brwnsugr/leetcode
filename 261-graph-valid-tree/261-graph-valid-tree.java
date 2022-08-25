class Solution {
    
    private Set<Integer> visited = new HashSet<>();
    
    
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean valid = isValid(adjList, 0, -1);
        
        return visited.size() != n ? false : valid;
    }
    
    private boolean isValid(List<List<Integer>> adjList, int curr, int prev) {
        if(visited.contains(curr)) {
            return false;
        }
    
        visited.add(curr); 
        List<Integer> neighbors = adjList.get(curr);
        for(int neighbor : neighbors) {
            if(neighbor == prev) continue;
            if(!isValid(adjList, neighbor, curr)) return false;
            
        }
        return true;
    }
    
    
}