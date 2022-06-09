class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges) {
            int prev = edge[0];
            int dest = edge[1];
            adjList.get(prev).add(dest);
            adjList.get(dest).add(prev);
        }
        
        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(0, -1);
        Stack<Integer> st = new Stack<>();
        
        st.add(0);
        
        while(!st.isEmpty()) {
            int curr = st.pop();
            for(int neighbor : adjList.get(curr)) {
                if(parentMap.get(curr) == neighbor) continue;
                if(parentMap.containsKey(neighbor)) return false;
                st.add(neighbor);
                parentMap.put(neighbor, curr);
            }
        }
        
        return parentMap.size() == n;
    }
}

/**

        1(n)
       2^ 3
      4(n)

map(2: 1, )


**/