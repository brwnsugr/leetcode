class Solution {
  public int compareVersion(String version1, String version2) {

    /**
     * we compare both part of the version1 , 2
     * v1: 1.0.1, v2: 1.0.2
     *
     * any part we meet which is bigger, then return the right integer
     *
     * but we would not meet which is bigger until the end, return 0
     *
     */

    Queue<Integer> v1 = new LinkedList<>();
    Queue<Integer> v2 = new LinkedList<>();
    addNumericVersionByDot(version1, v1);
    addNumericVersionByDot(version2, v2);

    while(!v1.isEmpty() || !v2.isEmpty()) {
      int unitVersion1 = v1.isEmpty() ? 0 : v1.poll();
      int unitVersion2 = v2.isEmpty() ? 0 : v2.poll();
      if(unitVersion1 > unitVersion2) return 1;
      if(unitVersion1 < unitVersion2) return -1;
    }
    return 0;
  }

  private void addNumericVersionByDot(String version, Queue<Integer> q) {
    int start = 0;
    for(int i = 0; i < version.length(); i++) {
      if(version.charAt(i) == '.') {
        q.add(getNumericVersion(version.substring(start, i)));
        start = i+1;
      }
    }
    q.add(getNumericVersion(version.substring(start)));
  }

  private int getNumericVersion(String input) {
    return Integer.valueOf(input);
  }
}