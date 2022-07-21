class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1, 0, new LinkedList<>());
        return answer;
    }
    
    private void backTrack(int n, int k, int curr, int count, LinkedList list) {
        if(count == k) {
            answer.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int i = curr; i <= n; i++) {
                list.addLast(i);
                backTrack(n, k, i+1, count+1, list);
                list.removeLast();
            }    
        }
    }
    
    
}