class Solution {
  public int countComponents(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    int count = n;

    /**traverse all the pair of edges, union the pair,
     * and if it has already connected, skip
     * and if it's not, union and decrease count by 1.
     */

    for(int[] edge : edges) {
      if(!uf.isConnected(edge[0], edge[1])) {
        uf.union(edge[0], edge[1]);
        count--;
      }
    }
    return count;
  }
}

class UnionFind {

  int[] parents;
  int size;

  public UnionFind(int n) {
    parents = new int[n];
    size = n;
    for(int i = 0; i < n; i++) parents[i] = i;
  }

  public int find(int x) {
    return parents[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if(rootX == rootY) return;
    else {
      for(int i = 0; i < size; i++) {
        if(parents[i] == rootY) parents[i] = rootX;
      }
    }
  }
  
  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}