class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numPlaces = new HashSet<>();
        for(int num : nums) numPlaces.add(num);
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int tempLength = 1;
            if(!numPlaces.contains(curr-1)) {
                while(numPlaces.contains(curr + 1)){
                    curr++;
                    tempLength++;
                }
            }
            answer = Math.max(answer, tempLength);
        }
        return answer;
    }
}