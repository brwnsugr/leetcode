class Solution {
    
    private boolean[][] cache;
    public int countSubstrings(String s) {
        // abc -> a, b,c, 
        int len = s.length();
        cache = new boolean[len][len];
        // aaa -> a, a, a, aa, aa, aaa
        // (xx) -> palindrome -> (xx)y ->
        
        // (xxx) -> xxxyz
        //    (xx) -> p ,, -> if (z)(xx)(z) , y==z -> p
        // z,x,x,z  xx, zxxz -> 6
        
        for(int i = 0; i < len; i++) cache[i][i] = true;
        
        int palindromeCount = 0;
        
        //
        
        for(int i = 0; i < len-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) cache[i][i+1] = true;
        }
        
        for(int width = 3; width <= len; width++) {
            for(int start = 0; start < len - width + 1; start++) {
                if(isRangePalindrome(start, start+width-1, s)) cache[start][start+width-1] = true;
            }
        }
                   
                   
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(cache[i][j]) palindromeCount++;
            }
        }
        
        return palindromeCount;
        // a(a)bb -> 
    }
    
    private boolean isRangePalindrome(int start, int end, String s) {
        if(start == end) {
            cache[start][end] = true;
            return true;
        }
        else if(end-start == 1){
            if(s.charAt(end) == s.charAt(start)) {
                cache[start][end] = true;
                return true;
            }
        }
        else {
            if(cache[start+1][end-1] && s.charAt(start) == s.charAt(end)) {
                cache[start][end] = true;
                return true;
            }
        }
        return false;
    }
}