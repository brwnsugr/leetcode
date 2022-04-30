class Solution {
    
    Set<Integer> courseLearned = new HashSet<>();
    private Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private boolean canFinish;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        canFinish = true;
        //init 
        for(int[] prerequisite : prerequisites) {
            int start = prerequisite[0];
            int end = prerequisite[1];
            if(!adjMap.containsKey(start)) {
                adjMap.put(start, new ArrayList<>());
            }
            if(!adjMap.containsKey(end)) {
                adjMap.put(end, new ArrayList<>());
            }
            adjMap.get(start).add(end);
        }
        
        Set<Integer> currentLearned = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            int startCourse = i;
            dfs(startCourse, currentLearned);
            if(!canFinish) return false;
        }
        return canFinish;
    }
    // 1->4, 2->4, 3->1 3->2
    
    private void dfs(int currentCourse, Set<Integer> currentLearned) {
        
        if(courseLearned.contains(currentCourse)) {
            return;
        }
        if(currentLearned.contains(currentCourse)) {
            canFinish = false;
            return;
        }
        List<Integer> nextCourses = adjMap.get(currentCourse);
        if(nextCourses == null) return;
        currentLearned.add(currentCourse);
        for(int nextCourse : nextCourses) {
            dfs(nextCourse, currentLearned);
        }
        currentLearned.remove(currentCourse);
        
        courseLearned.add(currentCourse);
        return;
    }
}