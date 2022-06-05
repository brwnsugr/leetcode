class Solution {
    
    private Set<Integer> visited = new HashSet<>();
    
    public int countComponents(int n, int[][] edges) {
        int componentCount = 0;
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
            
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i, adjList);
                componentCount++;
            }
            
        }
        
        return componentCount;
    }
    
    private void dfs(int curr, List<List<Integer>> adjList) {
        visited.add(curr);
        for(int neighbor : adjList.get(curr)){
            if(!visited.contains(neighbor)) {
                dfs(neighbor, adjList);
            }
        }
    }
}