class Solution {
    private List<List<Integer>> adjList = new ArrayList<>();
    
    public boolean validTree(int n, int[][] edges) {    
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges) {
            int prev = edge[0];
            int dest = edge[1];
            adjList.get(prev).add(dest);
            adjList.get(dest).add(prev);
        }
        
        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(0, -1);
        return dfs(0, parentMap) && parentMap.size() == n;
//         Stack<Integer> st = new Stack<>();
        
//         st.add(0);
        
//         while(!st.isEmpty()) {
//             int curr = st.pop();
//             for(int neighbor : adjList.get(curr)) {
//                 if(parentMap.get(curr) == neighbor) continue;
//                 if(parentMap.containsKey(neighbor)) return false;
//                 st.add(neighbor);
//                 parentMap.put(neighbor, curr);
//             }
//         }
        
//         return parentMap.size() == n;
    }
    
    
    private boolean dfs(int curr, Map<Integer, Integer> parentMap) {
        for(int neighbor : adjList.get(curr)) {
            if(parentMap.get(curr) == neighbor) continue;
            if(parentMap.containsKey(neighbor)) return false;
            parentMap.put(neighbor, curr);
            boolean neighborACyclic = dfs(neighbor, parentMap);
            if(!neighborACyclic) return false;
        }
        return true;
    }
}

/**

        1(n)
       2^ 3
      4(n)

map(2: 1, )


**/