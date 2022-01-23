import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> m = new HashMap<>();

    for(int num : nums) {
      if(!m.containsKey(num)) m.put(num, 1);
      else m.put(num, m.get(num) + 1);
    }

    Set<Entry<Integer, Integer>> entries = m.entrySet();

    SortedMap<Integer, List<Integer>> sortedMap = new TreeMap<>((s1, s2) -> s2 - s1);
    for(Entry<Integer,Integer> entry : entries) {
      if(sortedMap.containsKey(entry.getValue())) {
        sortedMap.get(entry.getValue()).add(entry.getKey());
      }
      else {
        sortedMap.put(entry.getValue(), new ArrayList<>());
        sortedMap.get(entry.getValue()).add(entry.getKey());
      }
    }
    int i = 0;
    int[] ans = new int[k];

    for(Entry<Integer,List<Integer>> entry : sortedMap.entrySet()) {
      List<Integer> values = entry.getValue();
      for(int value : values) {
        ans[i] = value;
        i++;
        if(i == k) break;
      }
      if(i == k) break;
    }
    return ans;
  }
}