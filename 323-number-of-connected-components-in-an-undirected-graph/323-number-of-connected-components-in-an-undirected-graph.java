class Solution {
    public int countComponents(int n, int[][] edges) {
        
        // 1. Define the right DS to store the vertex and its adj nodes as List first
        // 2. So, For each nodes, We traverse its adjcent Nodes in the adjList til possible they can. and mark if that node visited.
        // 3. After that cycle above, add count and traverse from other nodes which has not been visited.  
        
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        //init adjMap for all nodes with each value list size 0
        
        for(int i = 0; i < n; i++) adjMap.put(i, new ArrayList<>());
        
        int count = 0;
        
        for(int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]); // since it's Undirected Graph we add both sides. 
        }
        
        //for Each Node which has not visited, Start Traverse following its adjacent nodes and recursively do it. then its adj node would be the new start node in this traverse. so the new startnode traverse to its adjNodes . while there's no nodes to traverse in this recursive logic. 
        
        // and after that, we add 1 to the count val and Start from other nodes not visited.
        
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                traverse(visited, adjMap, i);
                count++;
            }
        }
        
        
        return count;
    }
    
    
    private void traverse(Set<Integer> visited, Map<Integer,List<Integer>> adjMap, int curr) {
        visited.add(curr);
        List<Integer> adjList = adjMap.get(curr);
        for(int next : adjList) {
            if(!visited.contains(next)) traverse(visited, adjMap, next);
        }
        return;
    }
}