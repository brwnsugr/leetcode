class Solution {
    public long numberOfWays(String s) {
        long answer = 0;
        
        int[] onePrefixSum = new int[s.length()];
        int[] zeroPrefixSum = new int[s.length()];
        
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i == 0) {
                if(c == '1') onePrefixSum[i] = 1;
                else zeroPrefixSum[i] = 1;
            }
            else {
                onePrefixSum[i] = onePrefixSum[i-1];
                zeroPrefixSum[i] = zeroPrefixSum[i-1];
                if(c == '1') onePrefixSum[i]++;
                else zeroPrefixSum[i]++;
            }
        }
        
        for(int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            
            if(c == '1') {
                answer += zeroPrefixSum[i-1] * (zeroPrefixSum[s.length() - 1] - zeroPrefixSum[i]);
            }
            else {
                answer += onePrefixSum[i-1] * (onePrefixSum[s.length() - 1] - onePrefixSum[i]);
            }
        }
    
        return answer;
    }
}