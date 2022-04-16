class Solution {
    
    private int targetCount;
    private int maxNum;
    private List<List<Integer>> answers = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        targetCount = k;
        maxNum = n;
        LinkedList<Integer> path = new LinkedList<>();
        recursive(1, 0, path);
        return answers;
    }
    
    private void recursive(int curr, int count, LinkedList<Integer> path) {
        
        if(curr == maxNum +1) {
            if(count == targetCount) {
                answers.add(new ArrayList<>(path));
            }
            return;
        }
        
        else {
            //원소 넣기
            path.addLast(curr);
            recursive(curr+1, count+1, path);
            path.removeLast();
            
            //원소 빼기 
            recursive(curr+1, count, path);
        }
    }
}