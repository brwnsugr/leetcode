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
        List<Integer> groups = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) count++; //"1100"
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);
        
        int answer = 0;
        for(int i = 0; i < groups.size()-1; i++) {
            int next = i + 1;
            answer += Math.min(groups.get(i), groups.get(next));
        }
        return answer;
    }
}