class Solution {
    public long appealSum(String s) {
        long answer = 0;
        
        int[] lastIndices = new int[26];
        Arrays.fill(lastIndices, -1);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int right = s.length() - i;
            int left = i - lastIndices[c-'a'];
            answer += (long)(left * right);
            lastIndices[c-'a'] = i;
        }
        
        return answer;
    }
}