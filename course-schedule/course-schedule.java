class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjList = new ArrayList<>(numCourses);
    int[] inflowCount = new int[numCourses];
    if(prerequisites.length == 0) return true;
    for(int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }

    for(int[] prerequisite : prerequisites) {
      adjList.get(prerequisite[1]).add(prerequisite[0]);
      inflowCount[prerequisite[0]]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
      if(inflowCount[i] == 0) q.add(i);
    }

    if(q.isEmpty()) return false;

    while(!q.isEmpty()) {
      int curr = q.poll();
      List<Integer> nextSteps = adjList.get(curr);
      for(int next : nextSteps) {
        inflowCount[next]--;
        if(inflowCount[next] == 0) q.add(next);
      }
    }
    int cnt = 0;
    for(int i = 0; i < numCourses; i++){
      if(inflowCount[i] == 0) cnt++;
    }
    return numCourses == cnt;
  }
}