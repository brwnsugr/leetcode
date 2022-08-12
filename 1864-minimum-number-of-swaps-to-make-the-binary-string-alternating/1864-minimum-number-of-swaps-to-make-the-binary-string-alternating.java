class Solution {
    public int minSwaps(String s) {
        
        int ones = 0;
        int zeros = 0;
        int oddOnes = 0;
        int oddZeros = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '1') ones++;
            else zeros++;
        }
        
        if(s.length() % 2 == 0 && ones != zeros) return -1;
        if(s.length() % 2 == 1 && Math.abs(ones - zeros) >= 2) return -1;
        
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 == 0) {
                char c = s.charAt(i);
                if(c == '1') oddOnes++;
                else oddZeros++;
            }
        }
        
        if(s.length() % 2 == 0) return Math.min(oddOnes, oddZeros);
        else {
            if(Math.abs(ones - zeros) == 1) return ones > zeros ? oddZeros : oddOnes;
            else return Math.min(oddZeros, oddOnes);
        }
    }
}