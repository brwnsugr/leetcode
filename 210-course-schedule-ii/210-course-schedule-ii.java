class Solution {
    private Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private Map<Integer, Integer> inDegrees = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // [[1,0],[2,0]]
        //  0->1, 0->2.
        // prerequisites = []
        // [0,1,2,3]
        // numcourse = 0, []
        if(numCourses == 0) return new int[0];
        if(prerequisites.length == 0){
            int[] answer = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                answer[i] = i;
            }
            return answer;
        }

        buildGraph(numCourses, prerequisites);

        Queue<Integer> q = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        List<Integer> answerList = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            for(int neighbor : adjMap.get(currNode)){
                inDegrees.put(neighbor, inDegrees.get(neighbor)-1);
                if(inDegrees.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }   
            answerList.add(currNode);
        }
        if(answerList.size() == numCourses) {
            int[] answer = new int[answerList.size()];
            for(int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
        else{
            return new int[0];
        }

    }

    private void buildGraph(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            inDegrees.put(i, 0);
            adjMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int prev = prerequisite[1];
            int curr = prerequisite[0];
            adjMap.get(prev).add(curr);
            inDegrees.put(curr, inDegrees.getOrDefault(curr, 0) + 1);
        }
    }
}