class Solution {
    public int countBinarySubstrings(String s) {
        /*
          
        flip = f  
            ^   
        001101 -> [2,2,1,1] -> 2 + 1 + 1 = 
                    ^ *  l: 2, r: 2 ,steps += min(l,r)
        00110011 ->[2,2,2,2] -> 2 + 2 + 2 = 6
        
        10101 -> [1,1,1,1,1]-> 1 + 1 + 1 + 1 = 4
        */
        
        
            //                 ^ ^
        // 110001111000000 -> [2,3,4,6]
        
        if(s.length() == 1) return 0;
        int[] groups = new int[s.length()];
        groups[0] = 1;
        int count = 1;
        int t = 0;
        for(int i = 1; i < s.length(); i++) {                // g[0] = 2, g[1]=2, 
            if(s.charAt(i) != s.charAt(i-1)) groups[++t]=1; //"1100"
            else {
                groups[t]++;
            }
        }
        
        
        int answer = 0;
        for(int i = 0; i < t; i++) {
            int next = i + 1;
            answer += Math.min(groups[i], groups[next]);
        }
        return answer;
    }
}