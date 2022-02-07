class Solution {
  public boolean validTree(int n, int[][] edges) {

    /**
     * Graph is Valid Tree if these are true
     * - There is no cycle.
     * - The graph is all connected
     *
     * First of all, We traverse from the adjacent vertexes from the start node
     *
     *
     *  0 - 1 - 2
     *      \ \ |
     *      4  3
     *           2,3,4 is adj nodes of 1
     *  0 -> 1 -> 2,3,4 -> 2 -> 3(x) Cyclic ! so that's false
     *
     *  So, using queue in order to traverse adj nodes first.
     * and also, we have to check if it's visited using hashSet of nodes.
     *
     * after all traverse, if hashSet size equals number of all nodes, that's true
     * but if not, that's false as We haven't visited all of it. so it's not connected.
     */
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    /**
     * build up the adjListMap to represent the tree.
     */
    for(int i = 0; i < n; i++) {
      adjMap.put(i, new ArrayList<>());
    }

    for(int[] edge : edges) {
      adjMap.get(edge[0]).add(edge[1]);
      adjMap.get(edge[1]).add(edge[0]);
    }

    Map<Integer, Integer> parents = new HashMap<>();

    /**
     * Enqueue the starting vertex. and
     * it's obvious no matter which nodes for start we choose. cuz we will traverse all nodes
     * at least if they're all connected.
     */

    q.add(0);
    parents.put(0, -1);

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int next : adjMap.get(curr)) {
        if(parents.get(curr) == next) continue;
        if(parents.containsKey(next)) return false;

        parents.put(next, curr);
        q.add(next);
      }
    }
    return parents.size() == n;
  }
}