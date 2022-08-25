class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> outBounds = new ArrayList<>();
        Set<Integer> orders = new HashSet<>();
        for(int i = 0; i < numCourses; i++) outBounds.add(new ArrayList<>());
        
        for(int[] prerequisite : prerequisites){
            int preNode = prerequisite[0];
            int destnode = prerequisite[1];
            inDegree[destnode]++;
            outBounds.get(preNode).add(destnode);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        //init with nodes that has no inbounds
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int neighbor : outBounds.get(curr)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
            orders.add(curr);
        }
        
        return numCourses == orders.size();
    }
}