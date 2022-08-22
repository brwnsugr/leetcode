class Solution {
    public int longestConsecutive(int[] nums) {
        
        
        // 100 101 ~ 102, 
        // 4~ , 1, 
        int answer = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) numSet.add(num);
        
        
        for(int num : nums) {
            if(numSet.contains(num - 1)) continue;
            else if(numSet.contains(num)){
                int cnt = 1;
                while(numSet.contains(num + 1)){
                    cnt++;
                    num++;
                }
                answer = Math.max(answer, cnt);
            }
        }
        
        
        
        return answer;
    }
}