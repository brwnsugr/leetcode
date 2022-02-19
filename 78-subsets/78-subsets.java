class Solution {
    
    private List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        /*
       [ 1]
      /   |   \
     1    2    3
    /|\ 
         
        */
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        for(int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for(List<Integer> curr : res) {
                List<Integer> temp = new ArrayList<>(curr);
                temp.add(num);
                newSubsets.add(temp);
            }
            
            for(List<Integer> subset : newSubsets) {
                res.add(subset);
            }
        }
        
        return res;
        
    }

    
    
    
}