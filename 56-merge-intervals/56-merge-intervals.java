class Solution {
  public int[][] merge(int[][] intervals) {
    /**
     *
     * interval을 start time 기준, ascending order로 정렬 ->
     * 이렇게 해야 마지막 원소의 end time 과 현재 순회중인 interval의 start time을 비교할 때, 순회중인 interval은 항상 마지막 원소의 start time 보다 크므로, interval merge 시,
     * 이전 interval의 start time 은 신경쓰지 않아도 됨 (이전 원소의 start time은 어차피 현재 interval 의 start time보다 작으므로 merge 시, 값 변경이 없음)
     *
     * 첫 번째 interval 원소를 새로운 list 에다 넣은 후,
     * 두번째 interval 원소와 새로운 list 의 가장 최근 원소를 비교하여
     * 먼저, 이 새로운 list 는 ArrayList 로 구현하자. (이유: 동적으로 원소를 넣을 수 있고, 마지막 원소를 뽑는데, T.C가 O(1)
     *
     *
     * case 1. 가장 최근 원소의 end time >= 새로운 원소 start time이면, 가장 최근 원소의 end time을 새로운 원소의 end time 으로 업데이트 하고,
     * 다음 interval 로 순회
     * case 2. 가장 최근 원소의 end time < 새로운 원소 start 새 list 에 새로운 원소를 그대로 넣어줌
     */
    if(intervals.length == 1) return intervals;

    Arrays.sort(intervals, new Comparator<>(){
      @Override
      public int compare(int[] t1, int[] t2) {
        return t1[0] - t2[0];
      }
    });

    List<int[]> list = new ArrayList<>();

    list.add(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] lastInterval = list.get(list.size() - 1);

      if(lastInterval[1] >= intervals[i][0]) lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
      else {
        list.add(intervals[i]);
      }
    }
    return list.toArray(new int[list.size()][]);
  }
}