class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] p = new int[n+1];
        p[0] = 0;
        for(int i = 0; i < n; i++) {
            int temp = s.charAt(i) == '1' ? 1 : 0;
            p[i+1] = p[i] + temp;
        }
        
        /*
        check all the elements 0 or 1
        */
        if(p[n-1] == n || p[n-1] == 0) return 0;
        int answer = Integer.MAX_VALUE;
        //[0,1,2,2,3,4] "00110"
        //left part len = 0, right len = n
        // answer = Math.min(answer, n - p[n-1]);
        
        for(int i = 0; i <= n; i++) {
            //left number of '1's
            int leftZeros = p[i]; // [0^,1,2,2,3,4] lz = 0, [0,1,2,2,3,4] rO = 5 - 0-1 - (4-0)
            
            //right number of '0's
            int rightOnes = (n - i) - (p[n] - p[i]);
            answer = Math.min(answer, (leftZeros + rightOnes));
        }
        
        //"00110"
        return answer;
    }
}