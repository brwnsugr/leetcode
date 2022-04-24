class Solution {
    
    private int[] colors;
    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        return dfs(graph);
    }
    
    private boolean dfs(int[][] graph) {
        
        for(int i = 0; i < graph.length; i++) {
            if(colors[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                colors[i] = 1;
                while(!stack.isEmpty()) {
                    int curr = stack.pop();
                    int currColor = colors[curr];
                    int[] neighbors = graph[curr];
                    for(int neighbor : neighbors) {
                        if(colors[neighbor] == currColor) return false;
                        if(colors[neighbor] == 0) {
                            colors[neighbor] = currColor * (-1);
                            stack.add(neighbor);
                        }       
                    }
                }
            }
        }
        
        return true;
    }
}