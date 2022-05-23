class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                strBuilder.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        s = new String(strBuilder);
        
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        
        return true;
    }
}