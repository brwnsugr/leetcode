class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] prefixSums = new int[len + 1];
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '1') 
                prefixSums[i+1] = prefixSums[i] + 1;
            else prefixSums[i+1] = prefixSums[i];
        }
        
        if(prefixSums[len] == len || prefixSums[len] == 0) return 0;
        
        for(int i = 0; i <= len; i++) {
            int leftZeros = prefixSums[i];
            int rightOnes = (len - i) - (prefixSums[len] - prefixSums[i]);
            answer = Math.min(answer, leftZeros + rightOnes);
        }
        
        return answer;
    }
}