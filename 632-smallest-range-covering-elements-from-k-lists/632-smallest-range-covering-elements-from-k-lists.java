class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] next = new int[nums.size()];
        int left = 0;
        int right = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        boolean hasElementToCheck = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> nums.get(a).get(next[a]) - nums.get(b).get(next[b]));
        
        for(int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            pq.add(i);                                 
        }
        
        while(hasElementToCheck) {
            // for(int i = 0; i < nums.size(); i++) {
                // for(int j = 0; j < nums.get(i).size(); j++) {
                    Integer minIdx = pq.poll();
            
                    if( max - nums.get(minIdx).get(next[minIdx]) < right - left) {
                        left = nums.get(minIdx).get(next[minIdx]);
                        right = max;
                    }

                    next[minIdx]++;

                    if(next[minIdx] == nums.get(minIdx).size()) {
                        hasElementToCheck = false;
                        break;
                    }

                    pq.add(minIdx);
                    max = Math.max(max, nums.get(minIdx).get(next[minIdx]));
                // }
                
            // }

        }
        
        return new int[]{left, right};
    }
}