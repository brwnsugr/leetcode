class Solution {
    
    
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        parentMap.put(0,-1);
        
        
        st.add(0);
        
        while(!st.isEmpty()) {
            int curr = st.pop();
            
            for(int neighbor : adjList.get(curr)){
                if(parentMap.get(curr)==neighbor) continue;
                if(parentMap.containsKey(neighbor)) return false;
                
                st.add(neighbor);
                parentMap.put(neighbor, curr);
            }
        }
        
        
        return parentMap.size() == n;
    }
}