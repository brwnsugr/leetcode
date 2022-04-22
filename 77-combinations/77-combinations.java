class Solution {
    
    List<List<Integer>> answers = new ArrayList<>();
    private int targetK;
    
    
    public List<List<Integer>> combine(int n, int k) {
        // 
        // 4P2 = 4C2 * 2!  
        // 1,2,3,     x-> (2 ->(3 or x) or x -> ) ->
        //            1 -> (2 or x)
        // 
        //   1,2
        // n = 4,, k = 2
        // -> 1^,2^,3,4          pickedCount = 0, 
        // [1,2]              pickedCount = 2
        // O(2^N) -> 
        //
        targetK = k;
        LinkedList<Integer> paths = new LinkedList<>();
        comb(n, 1, 0, paths);
        return answers;
    }
    
    
    private void comb(int n, int currNumber, int pickedCount, LinkedList<Integer> paths) {
        
        if(pickedCount == targetK) {
            answers.add(new ArrayList<>(paths));
            return;
        }
        
        if(currNumber > n) {
            return;
        }
        
        
        //1. 현재꺼를 pick
        paths.addLast(currNumber); // n = 4, k = 2.  [3, 4] 2 paths = [1]
        comb(n, currNumber+1, pickedCount+1, paths);
        paths.removeLast();
        
        //2. 현재꺼를 pick X
        comb(n, currNumber+1, pickedCount, paths);
        
        
    }
    
    
    
}