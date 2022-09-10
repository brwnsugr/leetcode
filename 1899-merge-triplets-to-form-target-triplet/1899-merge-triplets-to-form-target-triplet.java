class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean[] greedy = new boolean[3];
        
        for(int[] triplet : triplets) {
            boolean atLeastBigger = false;
            for(int i = 0; i < 3; i++) {
                if(triplet[i] > target[i]) {
                    atLeastBigger = true;
                    break;
                }
            }
            
            if(atLeastBigger) continue;
            
            for(int i = 0; i < 3; i++) {
                if(triplet[i] == target[i]) greedy[i] = true;
            }
        }
        
        return greedy[0] && greedy[1] && greedy[2];
    }
}