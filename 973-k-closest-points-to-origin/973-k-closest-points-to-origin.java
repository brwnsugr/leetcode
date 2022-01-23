import java.util.SortedMap;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    if(points.length == 1) return new int[][]{{points[0][0], points[0][1]}};
    SortedMap<Integer, List<int[]>> m = new TreeMap<>();
    for(int[] point : points) {
      int absY = Math.abs(point[0]);
      int absX = Math.abs(point[1]);
      int dist = absY * absY + absX * absX;
      if(m.containsKey(dist)) {
        m.get(dist).add(new int[]{point[0], point[1]});
      }
      else {
        m.put(dist, new ArrayList<>());
        m.get(dist).add(new int[]{point[0], point[1]});
      }
    }

    m.entrySet();
    int i = 0;
    int[][] ans = new int[k][2];
    for(Entry<Integer, List<int[]>> entry : m.entrySet()) {
      List<int[]> closePoints = entry.getValue();
      for(int[] point : closePoints) {
        ans[i][0] = point[0];
        ans[i][1] = point[1];
        i++;
        if(i == k) break;
      }
      if(i==k) break;
    }

    return ans;
  }
}